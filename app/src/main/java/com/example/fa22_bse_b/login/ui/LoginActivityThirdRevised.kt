package com.example.fa22_bse_b.login.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.LoginPageRevisedBinding
import com.example.fa22_bse_b.databinding.LoginPageThirdRevisedBinding
import com.example.fa22_bse_b.login.model.LoginModel
import com.example.fa22_bse_b.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginActivityThirdRevised : AppCompatActivity() {
    val tag = "LoginActivityThirdRevised"

    val actualEmail: String = "ali@gmail.com"
    val actualPassword: String = "123456"

    var binding: LoginPageThirdRevisedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_page_third_revised)

        val loginModel: LoginModel = LoginModel(email = "ali@gmail.com", password = "")
        binding?.loginModel = loginModel

        lifecycleScope.launch(Dispatchers.IO) {
            while(true) {
                Log.e(tag, "loginModel: $loginModel", )
                delay(1000)
            }
        }
    }
}