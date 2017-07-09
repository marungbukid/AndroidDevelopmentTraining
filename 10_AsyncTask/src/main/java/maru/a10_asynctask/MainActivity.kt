package maru.a10_asynctask

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.net.URL

class MainActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        object : AsyncTask<Void, Void, Void>() {

            override fun onPreExecute() {
                super.onPreExecute()
                // runs in UI Thread
            }

            override fun doInBackground(vararg p0: Void?): Void? {
                // runs in background thread

                makeHTTPRequest()

                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                // runs in UI Thread
            }

        }


    }

    fun makeHTTPRequest() {

        val url = URL("https://ghibliapi.herokuapp.com/")
        val http = url.openConnection()

    }


}