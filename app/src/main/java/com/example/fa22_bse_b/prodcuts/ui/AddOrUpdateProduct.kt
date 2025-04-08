package com.example.fa22_bse_b.prodcuts.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.ActivityAddOrRemoveProductBinding
import com.example.fa22_bse_b.prodcuts.model.Product
import com.example.fa22_bse_b.state_managment.SystemState

// UI Layer
class AddOrUpdateProduct : AppCompatActivity() {

    var binding: ActivityAddOrRemoveProductBinding? = null
    var product: Product = Product()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_or_remove_product)

        if(SystemState.product != null) {
            this@AddOrUpdateProduct.product = SystemState.product!!
            binding?.productIdEditText?.isEnabled = false
        }
        binding?.product = this@AddOrUpdateProduct.product

        binding?.submitButton?.setOnClickListener {
            SystemState.product = product
            finish()
        }
    }
}