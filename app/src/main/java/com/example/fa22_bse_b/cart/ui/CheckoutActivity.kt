package com.example.fa22_bse_b.cart.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.cart.adopter.CartAdopterMigrated
import com.example.fa22_bse_b.cart.viewmodel.CheckoutViewModel
import com.example.fa22_bse_b.databinding.ActivityCheckoutActivtyBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CheckoutActivity : AppCompatActivity() {

    var binding: ActivityCheckoutActivtyBinding? = null
    val checkoutViewModel: CheckoutViewModel by viewModels()

    var cartItemAdopter: CartAdopterMigrated? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_checkout_activty)
        binding?.checkoutViewModel = checkoutViewModel
        binding?.lifecycleOwner = this

        cartItemAdopter = CartAdopterMigrated()
        binding?.billRv?.adapter = cartItemAdopter
        binding?.billRv?.layoutManager = LinearLayoutManager(this)

        checkoutViewModel.cartItems.observe(this) {
            Log.e("TAG", "onCreate: list = $it", )
            cartItemAdopter?.submitList(it)
            cartItemAdopter?.notifyDataSetChanged()
        }
//        lifecycleScope.launch(Dispatchers.IO) {
//            while (true){
//                delay(500)
//                Log.e("TAG", "onCreate: card number = ${checkoutViewModel.cardNumber}")
//
//            }
//        }
    }
}