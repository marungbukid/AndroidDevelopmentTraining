package maru.a11_listview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import maru.a11_listview.R
import maru.a11_listview.models.President

class PresidentListAdapter(context: Context?, resource: Int, objects: MutableList<President>) :
        ArrayAdapter<President>(context, resource, objects) {

    private var ctx = context
    private var res = resource
    private var items = objects
    private var inflater = ctx?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        var holder: ViewHolder

        if (view == null) {
            view = inflater.inflate(res, parent, false)
            holder = ViewHolder()


            // api 26
            holder.name = view.findViewById<TextView>(R.id.txtName)
            holder.location = view.findViewById<TextView>(R.id.txtLocation)


            // api 25
            /*
                holder.name = view.findViewById(R.id.txtName) as TextView
                holder.location = view.findViewById(R.id.txtLocation) as TextView
             */

            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val president = items[position]

        holder.name?.text = president.name
        holder.location?.text  = president.location

        return view
    }

    inner class ViewHolder {
        var name: TextView? = null
        var location: TextView? = null
    }

}