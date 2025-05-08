package com.example.fa22_bse_b.login_migrated.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.circle_game.ui.GameActivity
import com.example.fa22_bse_b.databinding.ActivityLoginPageMigratedBinding
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import com.example.fa22_bse_b.login_migrated.model.LoginEntity
import com.example.fa22_bse_b.login_migrated.viewmodel.LoginViewModel
import com.example.fa22_bse_b.signup.ui.SignUpActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
            }
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch(Dispatchers.IO) {
            val db: LocalDataBase = LocalDataBase.getInstance(this@LoginMigratedActivity.applicationContext)

            val loginList: List<LoginEntity> = db.getLoginDao().getAllLogins()
            Log.e(tag, "onCreate:loginListloginList = $loginList ", )
        }
    }
}