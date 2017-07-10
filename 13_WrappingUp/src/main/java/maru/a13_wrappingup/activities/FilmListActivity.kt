package maru.a13_wrappingup.activities

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.JsonReader
import android.view.View
import android.widget.ListView
import maru.a13_wrappingup.R
import maru.a13_wrappingup.adapters.FilmListAdapter
import maru.a13_wrappingup.models.Film
import java.io.InputStreamReader
import java.net.URL

class FilmListActivity: AppCompatActivity() {

    private var filmListView: ListView? = null
    private var films: MutableList<Film> = mutableListOf()

    private lateinit var adapter: FilmListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmlist)

        filmListView = findViewById(R.id.lvFilmList) as ListView
        adapter = FilmListAdapter(this, R.layout.list_item_film, films)

        filmListView?.adapter = adapter

        filmListView?.setOnItemClickListener { adapterView, view, i, l ->
            val film = films[i]
            val filmDetailsIntent = Intent(view.context, FilmDetailsActivity::class.java)
            filmDetailsIntent.putExtra("film", film)
            startActivity(filmDetailsIntent)
        }

        StudioGhibliAPI().execute()
    }

    private fun updateList(list: MutableList<Film>?) {
        if (list != null) {
            if (list.size > 0) {
                films.clear()
                films.addAll(list)
                adapter.notifyDataSetChanged()
                findViewById(R.id.txtLoading).visibility = View.GONE
            }
        }
    }



    inner class StudioGhibliAPI: AsyncTask<Void, Void, MutableList<Film>>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }
        override fun doInBackground(vararg p0: Void?): MutableList<Film>? {
            return callStudioGhibliFilms()
        }
        override fun onPostExecute(result: MutableList<Film>?) {
            updateList(result)
        }


        private fun callStudioGhibliFilms(): MutableList<Film> {
            val url = URL("https://ghibliapi.herokuapp.com/films")
            val http = url.openConnection()
            val filmList = mutableListOf<Film>()

            http.connect()


            val reader = JsonReader(InputStreamReader(http.getInputStream()))

            reader.beginArray()
            while (reader.hasNext()) {

                var id = ""
                var title = ""

                reader.beginObject()
                while (reader.hasNext()) {
                    val name = reader.nextName()

                    when (name) {
                        "id" -> id = reader.nextString()
                        "title" -> title = reader.nextString()
                        else -> reader.skipValue()
                    }
                }
                reader.endObject()

                filmList.add(Film(id, title))

            }
            reader.endArray()


            return filmList
        }
    }

}