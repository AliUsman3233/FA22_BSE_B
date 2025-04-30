package com.example.fa22_bse_b

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_b.circle_game.ui.GameActivity
import com.example.fa22_bse_b.databinding.ActivityMainBinding
import com.example.fa22_bse_b.login.ui.LoginActivityThirdRevised
import com.example.fa22_bse_b.shared_helper.SharedPreferenceHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    var sharedPreferenceHelper: SharedPreferenceHelper? = null
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        sharedPreferenceHelper = SharedPreferenceHelper(this)

        lifecycleScope.launch(Dispatchers.IO) {
            val loadingThread = launch {
                while (true) {
                    for (i in 0..360) {
                        withContext(Dispatchers.Main) {
                            binding?.loading?.rotation = i.toFloat()
                        }
                    }
                }

            }
            delay(5000)
            loadingThread.cancel()
            withContext(Dispatchers.Main) {
                if (sharedPreferenceHelper?.getData("IsLoggedIn") == "YES") {
                    startActivity(Intent(this@MainActivity, GameActivity::class.java))
                } else {
                    startActivity(Intent(this@MainActivity, LoginActivityThirdRevised::class.java))
                }
                finish()
            }
        }

    }

}