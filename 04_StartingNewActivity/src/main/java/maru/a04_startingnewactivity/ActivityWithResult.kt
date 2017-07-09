package maru.a04_startingnewactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class ActivityWithResult: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_withresult)
    }

    override fun onBackPressed() {
        val resultIntent = Intent()

        resultIntent.putExtra("result", "I'm result from another activity")

        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

}