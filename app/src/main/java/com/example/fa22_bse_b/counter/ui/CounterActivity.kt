package com.example.fa22_bse_b.counter.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.counter.model.CounterModel

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        val counterModel: CounterModel = CounterModel(count = 0)

        val counterTvRef: TextView = findViewById(R.id.counter_tv)
        val counterButtonRef: Button = findViewById(R.id.counter_btn)
        val resetButtonRef: Button = findViewById(R.id.reset_btn)


        counterButtonRef.setOnClickListener {
//            val currentCountValue = counterTvRef.getText().toString().toString()
//            val newCountValue = currentCountValue.toInt()
//            counterTvRef.setText(newCountValue.toString())
            counterModel.count++
            counterTvRef.setText(counterModel.count.toString())
        }

        resetButtonRef.setOnClickListener {
            counterModel.count = 0
            counterTvRef.setText(counterModel.count.toString())
        }



    }
}