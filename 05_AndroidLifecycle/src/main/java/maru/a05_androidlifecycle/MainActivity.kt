package maru.a05_androidlifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity: AppCompatActivity() {

    /*
        Called on start of app/activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "onCreate Called", Toast.LENGTH_SHORT).show()
    }

    /*
        Called instantly after onCreate function is done
     */
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart Called", Toast.LENGTH_SHORT).show()
    }

    /*
        Called instantly after onStart function is done
     */
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume Called", Toast.LENGTH_SHORT).show()
    }

    /*
        Called instantly if the activity is partially visible
     */
    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause Called", Toast.LENGTH_SHORT).show()
    }

    /*
        Called instantly if the user pressed home or recents
     */
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop Called", Toast.LENGTH_SHORT).show()
    }

    /*
        Called instantly if the activity is stopped
     */
    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart Called", Toast.LENGTH_SHORT).show()
    }


    /*
        Called instantly if user/android cleared memory
        or user stopped the application
     */
    override fun onDestroy() {
        Toast.makeText(this, "onDestroy Called", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }

}