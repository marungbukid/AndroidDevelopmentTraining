package maru.a12_parsingjson

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.JsonReader
import android.widget.Toast
import maru.a12_parsingjson.models.Film
import java.io.InputStreamReader
import java.net.URL

class MainActivity: AppCompatActivity() {

    val films = mutableListOf<Film>()

    val ctx = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        object: AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                makeHTTPCall()

                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)

                for (item in films) {
                    Toast.makeText(ctx, item.title, Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

    fun makeHTTPCall() {

        val url = URL("https://ghibliapi.herokuapp.com/films")

        val http = url.openConnection()

        http.connect()

        val reader = JsonReader(InputStreamReader(http.getInputStream()))

        reader.beginArray()
        while (reader.hasNext()) {

            var id: String = ""
            var title: String = ""

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

            films.add(
                    Film(id, title)
            )

        }
        reader.endArray()

    }



}