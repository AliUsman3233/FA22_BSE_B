package com.example.fa22_bse_b.cart.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.FA22_BSE_Application
import com.example.fa22_bse_b.cart.model.CartItemEntity
import com.example.fa22_bse_b.cart.model.CheckoutDataModel
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckoutViewModel : ViewModel() {

    val cardNumberMLD: MutableLiveData<String> = MutableLiveData("")
    val addressMLD: MutableLiveData<String> = MutableLiveData("")

    val foramtedCardNumber: LiveData<String> = cardNumberMLD.switchMap {
        liveData {
            val cleaned = it.replace(" ", "") // remove existing spaces
            val formatted = cleaned.chunked(4).joinToString(" ")
            emit(formatted)
        }
    }

    val cartItems = LocalDataBase.getInstance().getCartItemDao().getAllCartItems().asLiveData()
}