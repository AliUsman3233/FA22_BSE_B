package com.example.fa22_bse_b.login.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.login.model.LoginModel
import com.example.fa22_bse_b.tiktak.tiktakActivity

class LoginActivity : AppCompatActivity() {
    val tag = "MainActivity"

    val actualEmail: String = "ali@gmail.com"
    val actualPassword: String = "123456"
    //    var passwordVisibilityState: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, "onCreate: function called ")
        Toast.makeText(this,"$tag onCreate", Toast.LENGTH_SHORT).show()

        setContentView(R.layout.login_page)

        val loginButtonRef: Button = findViewById(R.id.login_btn)
        val email_et_ref: EditText = findViewById(R.id.email_et)
        val password_et_ref: EditText = findViewById(R.id.password_et)
        email_et_ref.setText("ali@gmail.com")
        password_et_ref.setText("123456")
        loginButtonRef.setOnClickListener {

            Log.e(tag, "Login Button clicked")
            val enteredEmailValue:String = email_et_ref.getText().toString()
            val enteredPasswordValue: String = password_et_ref.getText().toString()
            if(enteredEmailValue == actualEmail && enteredPasswordValue == actualPassword) {
                Toast.makeText(this,"Valid Credentials, Login Successful", Toast.LENGTH_SHORT).show()
                val tiktalIntent = Intent(this, tiktakActivity::class.java).putExtra("email", actualEmail).putExtra("password", actualPassword)
                startActivity(tiktalIntent)
                finish()
            } else {
                Toast.makeText(this@LoginActivity,"Invalid Credentials", Toast.LENGTH_SHORT).show()
            }







//
//            Log.e(tag, "Email = ${enteredEmailValue}", )
//            Log.e(tag, "Password = ${enteredPasswordValue}", )
//
//            Log.e(tag, "Text showing on button  = ${loginButtonRef.getText().toString()}", )
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

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"$tag onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"$tag onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"$tag onDestroy", Toast.LENGTH_SHORT).show()
    }
}