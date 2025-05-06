package com.example.fa22_bse_b.login_migrated.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.circle_game.ui.GameActivity
import com.example.fa22_bse_b.databinding.ActivityLoginPageMigratedBinding
import com.example.fa22_bse_b.login_migrated.viewmodel.LoginViewModel
import com.example.fa22_bse_b.signup.ui.SignUpActivity

class LoginMigratedActivity : AppCompatActivity() {
    private val tag = "LoginMigratedActivity"

    private var binding: ActivityLoginPageMigratedBinding? = null
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_page_migrated)
        binding?.loginViewModel = loginViewModel
        loginViewModel.initSharedPrefHelper(this)
        binding?.lifecycleOwner = this

        loginViewModel.loginStateMLD.observe(this) { loginState ->
            if (loginState) {
                startActivity(Intent(this@LoginMigratedActivity, GameActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Login unsuccessful", Toast.LENGTH_SHORT).show()
            }
        }

        loginViewModel.signUpStateMLD.observe(this) { signUpState->
            if(signUpState) {
                startActivity(Intent(this@LoginMigratedActivity, SignUpActivity::class.java))
                finish()
            }
        }
    }
}