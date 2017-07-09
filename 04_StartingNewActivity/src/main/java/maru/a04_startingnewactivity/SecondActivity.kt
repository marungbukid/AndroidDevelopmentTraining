package maru.a04_startingnewactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val greetings = intent.extras.getString("greetings")


        val txtGreetings = findViewById(R.id.txtGreetings) as TextView

        txtGreetings.text = "Greetings from first activity: $greetings"

    }

}