package com.example.fa22_bse_b.counter_revised.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fa22_bse_b.R

class CountActivityRevised : AppCompatActivity() {

    //    var binding: ActivityCountRevisedBinding? = null

    var countValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_revised)


        val countTextViewRef: TextView = findViewById(R.id.count_tv)
        countTextViewRef.setText(countValue.toString())

        val countButtonRef: Button = findViewById(R.id.count_btn)

        countButtonRef.setOnClickListener {
            countValue++
            countTextViewRef.setText(countValue.toString())
        }





//        binding = DataBindingUtil.setContentView(this,R.layout.activity_count_revised)
//        binding?.countValue = SystemState.countState.toString()
//        val countBtnRef: Button = findViewById(R.id.count_btn)
//        val countTvRef: TextView = findViewById(R.id.count_tv)
//        binding?.countBtn?.setOnClickListener {
//            SystemState.countState++
////            binding?.countTv?.setText(SystemState.countState.toString())
//            binding?.countValue = SystemState.countState.toString()
//        }
    }
}