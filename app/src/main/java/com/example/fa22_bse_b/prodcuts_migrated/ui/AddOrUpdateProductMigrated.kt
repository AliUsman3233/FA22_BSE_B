package com.example.fa22_bse_b.prodcuts_migrated.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.ActivityAddOrRemoveProductBinding
import com.example.fa22_bse_b.databinding.ActivityAddOrRemoveProductMigratedBinding
import com.example.fa22_bse_b.prodcuts.model.Product
import com.example.fa22_bse_b.prodcuts_migrated.view_model.AddOrUpdateProductViewModel
import com.example.fa22_bse_b.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// UI Layer
class AddOrUpdateProductMigrated : AppCompatActivity() {

    var binding: ActivityAddOrRemoveProductMigratedBinding? = null

    val addOrUpdateProductViewModel: AddOrUpdateProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_or_remove_product_migrated)
        binding?.viewModel = addOrUpdateProductViewModel

        addOrUpdateProductViewModel.productAddedMLD.observe(this) {
            if(it == true) {
                Toast.makeText(this, "Product Added Successfully", Toast.LENGTH_SHORT).show()
                lifecycleScope.launch(Dispatchers.IO) {
                    delay(500)
                    withContext(Dispatchers.Main) {
                        finish()
                    }
                }

            }
        }

//        if(SystemState.product != null) {
//            this@AddOrUpdateProductMigrated.product = SystemState.product!!
//            binding?.productIdEditText?.isEnabled = false
//        }
//        binding?.product = this@AddOrUpdateProductMigrated.product
//
//        binding?.submitButton?.setOnClickListener {
//            SystemState.product = product
//            finish()
//        }
    }
}