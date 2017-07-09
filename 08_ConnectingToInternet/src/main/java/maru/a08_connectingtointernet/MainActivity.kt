package maru.a08_connectingtointernet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.net.URL

class MainActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeHTTPRequest()
    }

    fun makeHTTPRequest() {

        val url = URL("https://ghibliapi.herokuapp.com/")
        val http = url.openConnection()
        http.connect()

    }

}