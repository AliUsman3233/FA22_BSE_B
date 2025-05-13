package com.example.fa22_bse_b.prodcuts_migrated.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import com.example.fa22_bse_b.prodcuts.model.Product
import com.example.fa22_bse_b.prodcuts_migrated.model.ProductEntityMigrated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// View Model Layer
class AddOrUpdateProductViewModel: ViewModel() {

    var product: ProductEntityMigrated = ProductEntityMigrated()

    val productAddedMLD: MutableLiveData<Boolean> = MutableLiveData()


    fun onProductCreateTrigger() {
        viewModelScope.launch(Dispatchers.IO) {
            LocalDataBase.getInstance().getProductDao().addProductEntity(product)
        }
        productAddedMLD.value = true
    }


}