package com.example.fa22_bse_b.circle_game.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class GameView(context: Context, val radius: Float, val onCircleClickCallBack: () -> Int) :
    View(context) {
    val circlePaint = Paint()
    val scorePaint = Paint()

    var cX = radius
    var cY = radius
    var score = 0


    fun drawCircleAtRandomPosition() {
        cX = Random.nextDouble(radius.toDouble(), (width - radius).toDouble()).toFloat()
        cY = Random.nextDouble(radius.toDouble(), (height - radius).toDouble()).toFloat()
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

//        println("Touch is detected on x = ${event?.x}, y = ${event?.y}")

        if ((event?.x ?: 0f) > (cX - (radius*2)) && (event?.x ?: 0f) < cX + (radius*2) && (event?.y
                ?: 0f) > (cY - radius) && (event?.y ?: 0f) < cY + radius
        ) {
//            println("Touch is detected on circle x = ${event?.x}, y = ${event?.y}")
            score = onCircleClickCallBack.invoke()
            drawCircleAtRandomPosition()
        }


        return super.onTouchEvent(event)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        circlePaint.color = Color.BLUE
        if (score < 5) {
            scorePaint.color = Color.RED
        } else {
            scorePaint.color = Color.GREEN
        }
        scorePaint.textSize = 40f
        canvas.drawCircle(cX, cY, radius, circlePaint)

        canvas.drawText("Score  = $score", cX- (radius * 2), cY - (radius * 2), scorePaint)
    }

}