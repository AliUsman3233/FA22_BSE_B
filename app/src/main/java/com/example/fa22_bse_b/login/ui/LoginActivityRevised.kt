package com.example.fa22_bse_b.login.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.LoginPageRevisedBinding
import com.example.fa22_bse_b.login.model.LoginModel
import com.example.fa22_bse_b.state_managment.SystemState
import com.example.fa22_bse_b.tiktak.tiktakActivity

class LoginActivityRevised : AppCompatActivity() {
    val tag = "MainActivity"

    val actualEmail: String = "ali@gmail.com"
    val actualPassword: String = "123456"
    var binding: LoginPageRevisedBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, "onCreate: function called ")
        Toast.makeText(this, "$tag onCreate", Toast.LENGTH_SHORT).show()
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_revised)
        val loginModel: LoginModel = LoginModel(email = "ali@gmail.com", password = "123456")
        binding?.loginModel = loginModel
        binding?.loginBtn?.setOnClickListener {
            Log.e(tag, "Login Button clicked")
            if (loginModel.email == actualEmail && loginModel.password == actualPassword) {
                Toast.makeText(this, "Valid Credentials, Login Successful", Toast.LENGTH_SHORT)
                    .show()
                SystemState.loginState = true
                val tiktalIntent =
                    Intent(this, tiktakActivity::class.java).putExtra("email", actualEmail)
                        .putExtra("password", actualPassword)
                startActivity(tiktalIntent)
                finish()
            } else {
                Toast.makeText(this@LoginActivityRevised, "Invalid Credentials", Toast.LENGTH_SHORT)
                    .show()
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
        Toast.makeText(this, "$tag onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "$tag onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "$tag onDestroy", Toast.LENGTH_SHORT).show()
    }
}