package maru.a13_wrappingup.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import maru.a13_wrappingup.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFetchlist = findViewById(R.id.btnFetchList)

        btnFetchlist.setOnClickListener {
            startActivity(Intent(it.context, FilmListActivity::class.java))
        }

    }


}