package com.example.fa22_bse_b.circle_game.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

@SuppressLint("ViewConstructor")
class GameView(context: Context, private val radius: Float = 0f, val scoreCallBack: (Int) -> Unit) : View(context) {
    private val circlePaint = Paint()
    private val scorePaint = Paint().apply {
        textSize = 100f
    }
    private var cX: Float = radius
    private var cY: Float = radius
    private var score = 0
    private val colorList = arrayListOf(
        Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.YELLOW
    )

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if ((event?.x ?: 0f) > cX - radius && (event?.x ?: 0f) < cX + radius && (event?.y
                ?: 0f) > cY - radius && (event?.y ?: 0f) < cY + radius
        ) {
            score++
            scoreCallBack.invoke(score)
            println("Circle Start point = ${cX - radius}")
            println("Circle End point = ${cX + radius}")
            println("Circle Y Start point = ${cY - radius}")
            println("Circle Y End point = ${cY + radius}")
            println("cX = $cX, cY = $cY")
            println("radius = $radius")
            println("Click is inside of the circle at : ${event?.x}, ${event?.y}")
            drawCircleAtRandomPosition()
        } else {
            println("Click is outside of the circle at : ${event?.x}, ${event?.y}")
        }


        return super.onTouchEvent(event)
    }


    private fun drawCircleAtRandomPosition() {
        cX = Random.nextDouble(radius.toDouble(), (width - radius).toDouble()).toFloat()
        cY = Random.nextDouble(radius.toDouble(), (height - radius).toDouble()).toFloat()
        circlePaint.color = colorList[Random.nextInt(0, colorList.size - 1)]
        scorePaint.color = circlePaint.color
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(score.toString(), (width - 50).toFloat(), 100f, scorePaint)
        canvas.drawCircle(cX, cY, radius, circlePaint)
    }
}