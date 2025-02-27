package com.example.fa22_bse_b.login.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.login.model.LoginModel

class LoginActivity : AppCompatActivity() {
    val tag = "MainActivity"
    var passwordVisibilityState: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, "onCreate: function called ", )
        setContentView(R.layout.login_page)

        val loginButton: Button = findViewById(R.id.login_btn)

        val emailET: EditText = findViewById(R.id.email_et)
        val passwordEt: EditText = findViewById(R.id.password_et)
        val passwordToggle: ImageView = findViewById(R.id.passowrd_toggel)

        var loginModel: LoginModel

        loginButton.setOnClickListener({
            Log.e(tag, "Login button clicked")
//            Log.e(tag, "Email = ${emailET.getText()}")
//            Log.e(tag, "Password = ${passwordEt.getText()}")
            loginModel = LoginModel(email = emailET.getText().toString(), password = passwordEt.getText().toString())
            Log.e(tag,"LoginModel = $loginModel")
        })

        passwordToggle.setOnClickListener {
            passwordVisibilityState = !passwordVisibilityState
            Log.e(tag, "onCreate: ${passwordEt.inputType}", )
            if(passwordVisibilityState == true) {
                passwordEt.inputType = 1
                passwordToggle.setImageResource(R.drawable.baseline_disabled_visible_24)
            } else {
                passwordEt.inputType = 129
                passwordToggle.setImageResource(R.drawable.baseline_remove_red_eye_24)
            }


        }

    }
}