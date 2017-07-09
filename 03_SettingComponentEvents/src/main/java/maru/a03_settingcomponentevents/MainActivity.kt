package maru.a03_settingcomponentevents

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.*

class MainActivity: AppCompatActivity() {

    val ctx: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstTextView = findViewById(R.id.txtFirstTextview) as TextView
        val firstButton = findViewById(R.id.btnFirstButton) as Button
        val firstCheckBox = findViewById(R.id.cbFirstCheckBox) as CheckBox
        val radioGroup = findViewById(R.id.rgFirstRadioGroup) as RadioGroup

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
            Toast.makeText(it.context, "button clicked", Toast.LENGTH_SHORT).show()
        }

        firstCheckBox.setOnCheckedChangeListener { compoundButton, b ->
            Toast.makeText(compoundButton.context, "check changed", Toast.LENGTH_SHORT).show()
        }


        radioGroup.setOnCheckedChangeListener { radioGroupI, i ->
            Toast.makeText(radioGroupI.context, "check changed", Toast.LENGTH_SHORT).show()
        }

    }

}