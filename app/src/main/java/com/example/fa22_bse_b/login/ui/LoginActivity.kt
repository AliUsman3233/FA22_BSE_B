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

    //    var passwordVisibilityState: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, "onCreate: function called ")
        setContentView(R.layout.login_page)

        val loginButtonRef: Button = findViewById(R.id.login_btn)
        val email_et_ref: EditText = findViewById(R.id.email_et)
        val password_et_ref: EditText = findViewById(R.id.password_et)

        loginButtonRef.setOnClickListener {
            Log.e(tag, "Login Button clicked")
            val emailValue:String = email_et_ref.getText().toString()
            val passwordValue: String = password_et_ref.getText().toString()

            Log.e(tag, "Email = ${emailValue}", )
            Log.e(tag, "Password = ${passwordValue}", )

            Log.e(tag, "Text showing on button  = ${loginButtonRef.getText().toString()}", )
        }








//        passwordToggle.setOnClickListener {
//            passwordVisibilityState = !passwordVisibilityState
//            Log.e(tag, "onCreate: ${passwordEt.inputType}", )
//            if(passwordVisibilityState == true) {
//                passwordEt.inputType = 1
//                passwordToggle.setImageResource(R.drawable.baseline_disabled_visible_24)
//            } else {
//                passwordEt.inputType = 129
//                passwordToggle.setImageResource(R.drawable.baseline_remove_red_eye_24)
//            }
//
//
//        }

    }
}