package com.example.fa22_bse_b.circle_game.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameView = GameView(this, 50f)
        setContentView(gameView)
//
//        lifecycleScope.launch {
//            while(true) {
//                delay(200)
//                gameView.drawCircleAtRandomPosition()
//            }
//        }
    }
}