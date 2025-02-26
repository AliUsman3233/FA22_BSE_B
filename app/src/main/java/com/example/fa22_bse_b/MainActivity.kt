package com.example.fa22_bse_b

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, "onCreate: function called ", )
        setContentView(R.layout.login_page)

        val loginButton: Button = findViewById(R.id.login_btn)
        val emailET: EditText = findViewById(R.id.email_et)
        val passwordEt: EditText = findViewById(R.id.password_et)


        loginButton.setOnClickListener({
            Log.e(tag, "Login button clicked")
            Log.e(tag, "Email = ${emailET.getText()}")
            Log.e(tag, "Password = ${passwordEt.getText()}")
        })

    }

}