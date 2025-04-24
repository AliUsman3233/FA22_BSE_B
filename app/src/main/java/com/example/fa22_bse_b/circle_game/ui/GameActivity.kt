package com.example.fa22_bse_b.circle_game.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameView = GameView(this, radius = 50f, onCircleClickCallBack = {
            score++
            println("Current Score  = $score")
            score
        })
        setContentView(gameView)


        lifecycleScope.launch {
//            while(true) {
            delay(2000)
            gameView.drawCircleAtRandomPosition()
//            }
        }
    }
}