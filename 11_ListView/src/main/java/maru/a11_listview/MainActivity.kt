package maru.a11_listview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import maru.a11_listview.adapters.PresidentListAdapter
import maru.a11_listview.models.President

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presidents = mutableListOf(
                President("DU30", "PH"),
                President("Trump", "US"),
                President("Putin", "RU"),
                President("Xi Jinping", "CH"),
                President("Mugabe", "ZI"),
                President("Bidhya", "NE"),
                President("Pranab", "IN"),
                President("Tsai", "TA"),
                President("Kim Jong Un", "NK")
        )

        val adapter = PresidentListAdapter(this, R.layout.list_item_president, presidents)

        val listView = findViewById(R.id.lvSampleList) as ListView

        listView.adapter = adapter


    }

}