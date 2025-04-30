package com.example.fa22_bse_b.signup.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.ActivitySignupBinding
import com.example.fa22_bse_b.databinding.LoginPageRevisedBinding
import com.example.fa22_bse_b.databinding.LoginPageThirdRevisedBinding
import com.example.fa22_bse_b.login.model.LoginModel
import com.example.fa22_bse_b.shared_helper.SharedPreferenceHelper
import com.example.fa22_bse_b.signup.model.SignUpModel
import com.example.fa22_bse_b.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    val tag = "SignUpActivity"

    var binding: ActivitySignupBinding? = null
    val signUpModel: SignUpModel = SignUpModel()
    var sharedPreferenceHelper: SharedPreferenceHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding?.signupModel = this.signUpModel
        sharedPreferenceHelper = SharedPreferenceHelper(this@SignUpActivity)
        binding?.signupBtn?.setOnClickListener {
            sharedPreferenceHelper?.saveData(signUpModel.email, "email")
            sharedPreferenceHelper?.saveData(signUpModel.password, "password")

            lifecycleScope.launch {
                delay(2000)
                finish()
            }
        }
    }
}