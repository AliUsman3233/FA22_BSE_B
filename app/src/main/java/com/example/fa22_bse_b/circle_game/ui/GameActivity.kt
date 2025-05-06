package com.example.fa22_bse_b.circle_game.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_b.login.ui.LoginActivityThirdRevised
import com.example.fa22_bse_b.login_migrated.ui.LoginMigratedActivity
import com.example.fa22_bse_b.shared_helper.SharedPreferenceHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    var sharedPreferenceHelper: SharedPreferenceHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameView = GameView(this, 50f, scoreCallBack = {
            if(it > 5) {
                sharedPreferenceHelper?.saveData("No", "IsLoggedIn")
                startActivity(Intent(this, LoginMigratedActivity::class.java))
                finish()
            }
        })
        setContentView(gameView)
        sharedPreferenceHelper = SharedPreferenceHelper(this)
//
//        lifecycleScope.launch {
//            while(true) {
//                delay(200)
//                gameView.drawCircleAtRandomPosition()
//            }
//        }
    }
}