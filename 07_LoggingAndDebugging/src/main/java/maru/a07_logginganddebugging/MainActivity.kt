package maru.a07_logginganddebugging

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "Logging from debug panel")

        Log.e("MainActivity", "error log")

        val sumation = 45 + 55
        val avg = sumation / 100

        TODO("CRASH")
    }

}