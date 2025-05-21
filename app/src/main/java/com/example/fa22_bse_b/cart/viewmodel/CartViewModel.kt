package com.example.fa22_bse_b.cart.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.FA22_BSE_Application
import com.example.fa22_bse_b.cart.model.CartItemEntity
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartViewModel : ViewModel() {


    val cartItemsList: LiveData<List<CartItemEntity>> =
        LocalDataBase.getInstance().getCartItemDao().getAllCartItems().asLiveData()


    fun addProductToCart(productId: String) {
        Toast.makeText(
            FA22_BSE_Application.context?.applicationContext,
            "Process to add Product with Id = $productId is initiated",
            Toast.LENGTH_SHORT
        ).show()

        viewModelScope.launch(Dispatchers.IO) {
            val product =
                LocalDataBase.getInstance().getProductDao().getProductByEId(id = productId)
            val cartItem = CartItemEntity(
                id = product.id,
                imageUrl = product.imageUrl,
                desc = product.desc,
                company = product.company,
                price = product.price,
                discount = product.discount,
                quantity = 1,
                cartItemState = true
            )
            LocalDataBase.getInstance().getCartItemDao().addCartItem(cartItem)

            withContext(Dispatchers.Main) {
                Toast.makeText(
                    FA22_BSE_Application.context?.applicationContext,
                    "Product Added to Cart",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // add item to card
    }

    fun isProductIsAddedInCard(id: String): Int {
        return (cartItemsList.value?.filter { it.id == id }?.getOrNull(0)?.quantity ?: 0)
    }

    fun incrementInProductQuantity(cartItemId: String) {
        Toast.makeText(FA22_BSE_Application.context, "Tyring to increment in quantity", Toast.LENGTH_SHORT).show()
        viewModelScope.launch(Dispatchers.IO) {
            val cartItem = LocalDataBase.getInstance().getCartItemDao().getCartItemById(id = cartItemId)
            cartItem!!.quantity = cartItem.quantity + 1
            LocalDataBase.getInstance().getCartItemDao().updateCartItem(cartItem)
        }
    }

    fun decrementInProductQuantity(cartItemId: String) {
        Toast.makeText(FA22_BSE_Application.context, "Tyring to decrement in quantity", Toast.LENGTH_SHORT).show()
        viewModelScope.launch(Dispatchers.IO) {
            val cartItem = LocalDataBase.getInstance().getCartItemDao().getCartItemById(id = cartItemId)
            if(cartItem!!.quantity > 1) {
                cartItem.quantity = cartItem.quantity - 1
                LocalDataBase.getInstance().getCartItemDao().updateCartItem(cartItem)
            } else {
                LocalDataBase.getInstance().getCartItemDao().deleteCartItem(cartItem)
            }

        }
    }

}