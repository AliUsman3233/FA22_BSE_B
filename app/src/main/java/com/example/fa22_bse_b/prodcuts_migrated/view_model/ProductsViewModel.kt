package com.example.fa22_bse_b.prodcuts_migrated.view_model

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.FA22_BSE_Application
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import com.example.fa22_bse_b.prodcuts_migrated.model.ProductEntityMigrated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// View Model Layer
class ProductsViewModel : ViewModel() {

    val productListLD: LiveData<List<ProductEntityMigrated>> =
        LocalDataBase.getInstance().getProductDao().getAllProducts().asLiveData()


    val navigateToAddProductMLD: MutableLiveData<Boolean> = MutableLiveData()

    val navigateToUpdateProductMLD: MutableLiveData<String> = MutableLiveData()

    fun navigateToAddProductScreen() {
        navigateToAddProductMLD.value = true
    }

    fun removeProduct(id : String) {

        Toast.makeText(FA22_BSE_Application.context?.applicationContext, "Trying to remove product with id =$id ", Toast.LENGTH_SHORT).show()
        viewModelScope.launch(Dispatchers.IO) {
            // First Check
            val cartItem = LocalDataBase.getInstance().getCartItemDao().getCartItemById(id = id)
            cartItem?.let {
                LocalDataBase.getInstance().getCartItemDao().deleteCartItem(cartItem = cartItem)
            }
            LocalDataBase.getInstance().getProductDao().deleteProductRecordById(id)
        }
    }

    fun updateProduct(id: String) {
        Toast.makeText(FA22_BSE_Application.context?.applicationContext, "Trying to update product with id =$id ", Toast.LENGTH_SHORT).show()
        navigateToUpdateProductMLD.value = id
    }
}

