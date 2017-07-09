package maru.a04_startingnewactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.*

class MainActivity: AppCompatActivity() {

    val ctx: Context = this
    val REQUEST_CODE = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstTextView = findViewById(R.id.txtFirstTextview) as TextView
        val firstButton = findViewById(R.id.btnFirstButton) as Button
        val firstCheckBox = findViewById(R.id.cbFirstCheckBox) as CheckBox
        val radioGroup = findViewById(R.id.rgFirstRadioGroup) as RadioGroup

        val btnStartNewActivity = findViewById(R.id.btnStartNewActivity) as Button

        firstTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Toast.makeText(ctx, "After text changed", Toast.LENGTH_SHORT).show()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(ctx, "before text changed", Toast.LENGTH_SHORT).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(ctx, "ontext changed", Toast.LENGTH_SHORT).show()
            }
        })

        firstButton.setOnClickListener {
            // Toast.makeText(it.context, "button clicked", Toast.LENGTH_SHORT).show()

            val secondIntent = Intent(it.context, SecondActivity::class.java)
            secondIntent.putExtra("greetings", "Hello second activity")
            startActivity(secondIntent)

        }

        firstCheckBox.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(compoundButton.context, "check changed", Toast.LENGTH_SHORT).show()
        }


        radioGroup.setOnCheckedChangeListener { radioGroupI, i ->
            Toast.makeText(radioGroupI.context, "check changed", Toast.LENGTH_SHORT).show()
        }

        btnStartNewActivity.setOnClickListener {

            val withResultIntent = Intent(it.context, ActivityWithResult::class.java)


            startActivityForResult(withResultIntent, REQUEST_CODE)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {

            REQUEST_CODE -> {

                when (resultCode) {

                    Activity.RESULT_OK -> {

                        val resultFromActivity = data?.getStringExtra("result")

                        Toast.makeText(this, "result: $resultFromActivity", Toast.LENGTH_SHORT).show()

                    }

                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
                    }

                }

            }
            else -> Toast.makeText(this, "Other request code", Toast.LENGTH_SHORT).show()

        }

    }


}