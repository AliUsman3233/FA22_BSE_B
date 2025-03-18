package com.example.fa22_bse_b

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fa22_bse_b.state_managment.SystemState

class CountActivityRevised : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_revised)

        val countBtnRef: Button = findViewById(R.id.count_btn)
        val countTvRef: TextView = findViewById(R.id.count_tv)
        countBtnRef.setOnClickListener {
            SystemState.countState++
            countTvRef.setText(SystemState.countState.toString())
        }
    }
}