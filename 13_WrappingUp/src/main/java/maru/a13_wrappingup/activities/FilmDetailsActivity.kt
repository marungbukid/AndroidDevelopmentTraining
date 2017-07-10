package maru.a13_wrappingup.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import maru.a13_wrappingup.models.Film

class FilmDetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val film = intent.extras["film"] as Film

        Toast.makeText(this, film.title, Toast.LENGTH_SHORT).show()
    }

}