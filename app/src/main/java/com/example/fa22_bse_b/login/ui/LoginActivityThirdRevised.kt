package com.example.fa22_bse_b.login.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.circle_game.ui.GameActivity
import com.example.fa22_bse_b.databinding.LoginPageRevisedBinding
import com.example.fa22_bse_b.databinding.LoginPageThirdRevisedBinding
import com.example.fa22_bse_b.login.model.LoginModel
import com.example.fa22_bse_b.shared_helper.SharedPreferenceHelper
import com.example.fa22_bse_b.signup.ui.SignUpActivity
import com.example.fa22_bse_b.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivityThirdRevised : AppCompatActivity() {
    val tag = "LoginActivityThirdRevised"

    var binding: LoginPageThirdRevisedBinding? = null
    var sharedPreferenceHelper: SharedPreferenceHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_third_revised)

        val loginModel: LoginModel = LoginModel(email = "ali@gmail.com", password = "")
        binding?.loginModel = loginModel
        sharedPreferenceHelper = SharedPreferenceHelper(this@LoginActivityThirdRevised)


        binding?.root?.setOnClickListener {
            Log.e(tag, "onCreate: email = ${sharedPreferenceHelper?.getData("email")}", )
            Log.e(tag, "onCreate: password = ${sharedPreferenceHelper?.getData("password")}", )
        }

        binding?.signupBtn?.setOnClickListener {
            startActivity(Intent(this@LoginActivityThirdRevised, SignUpActivity::class.java))
        }

        binding?.loginBtn?.setOnClickListener {
            if(loginModel.email == sharedPreferenceHelper?.getData("email") && loginModel.password == sharedPreferenceHelper?.getData("password")) {
                sharedPreferenceHelper?.saveData("YES", "IsLoggedIn")
                startActivity(Intent(this@LoginActivityThirdRevised, GameActivity::class.java))
                finish()
            }
        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            while(true) {
//                Log.e(tag, "loginModel: $loginModel", )
//                delay(1000)
//            }
//        }
    }
}