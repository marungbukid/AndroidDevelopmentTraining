package maru.a13_wrappingup.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import maru.a13_wrappingup.R

class LoginActivity: AppCompatActivity() {

    private var loginButton: Button? = null
    private var usernameInput: EditText? = null
    private var passwordInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.btnLogin) as Button
        usernameInput = findViewById(R.id.edtUsername) as EditText
        passwordInput = findViewById(R.id.edtPassword) as EditText


        loginButton?.setOnClickListener {
            performLogin()
        }

    }

    private fun performLogin() {
        val username = usernameInput?.text.toString()
        val password = passwordInput?.text.toString()

        if (TextUtils.isEmpty(username) ||
            TextUtils.isEmpty(password)) {
            AlertDialog.Builder(this)
                    .setTitle("Login Error")
                    .setMessage("Please fill up the form")
                    .setPositiveButton("OK", null)
                    .show()
        } else {
            val mainActivityIntent = Intent(this, MainActivity::class.java)

            mainActivityIntent.putExtra("username", username)

            startActivity(mainActivityIntent)
            finish()
        }

    }

}