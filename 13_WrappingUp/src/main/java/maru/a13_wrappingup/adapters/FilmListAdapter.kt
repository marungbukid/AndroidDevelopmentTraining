package maru.a13_wrappingup.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import maru.a13_wrappingup.R
import maru.a13_wrappingup.models.Film

class FilmListAdapter(context: Context, resource: Int, objects: MutableList<Film>)
    : ArrayAdapter<Film>(context, resource, objects) {


    private var ctx = context
    private var res = resource
    private var items = objects
    private var inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        val holder: FilmViewHolder

        if (view == null) {
            view = inflater.inflate(res, parent, false)
            holder = FilmViewHolder()

            holder.id = view.findViewById<TextView>(R.id.txtFilmId)
            holder.title = view.findViewById<TextView>(R.id.txtFilmTitle)

            view.tag = holder
        } else {
            holder = view.tag as FilmViewHolder
        }

        val filmItem = items[position]

        holder.id.text = filmItem.id
        holder.title.text = filmItem.title

        return view
    }

    class FilmViewHolder {
        lateinit var id: TextView
        lateinit var title: TextView
    }

}