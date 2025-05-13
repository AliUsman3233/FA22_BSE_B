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

    fun navigateToAddProductScreen() {
        navigateToAddProductMLD.value = true
    }

    fun removeProduct(id : String) {

        Toast.makeText(FA22_BSE_Application.context?.applicationContext, "Trying to remove product with id =$id ", Toast.LENGTH_SHORT).show()
        viewModelScope.launch(Dispatchers.IO) {
            LocalDataBase.getInstance().getProductDao().deleteProductRecordById(id)
        }
        // Login to remove
    }
}