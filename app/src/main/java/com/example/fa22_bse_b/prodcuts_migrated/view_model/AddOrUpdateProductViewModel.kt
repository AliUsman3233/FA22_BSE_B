package com.example.fa22_bse_b.prodcuts_migrated.view_model

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.FA22_BSE_Application
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import com.example.fa22_bse_b.prodcuts_migrated.model.ProductEntityMigrated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// View Model Layer
class AddOrUpdateProductViewModel : ViewModel() {

    var product: ProductEntityMigrated = ProductEntityMigrated()

    val productAddedMLD: MutableLiveData<Boolean> = MutableLiveData()
    val screenStateMLD: MutableLiveData<ProductScreenState> = MutableLiveData()


    fun onProductCreateTrigger() {
        viewModelScope.launch(Dispatchers.IO) {
            if(screenStateMLD.value == ProductScreenState.Create){
                LocalDataBase.getInstance().getProductDao().addProductEntity(product)
            } else {
                LocalDataBase.getInstance().getProductDao().updateProductRecord(product)
            }
        }
        productAddedMLD.value = true
    }


    fun getProductForUpdate(productId: String) {
        Toast.makeText(
            FA22_BSE_Application.context?.applicationContext,
            "Trying to update a product with id = $productId",
            Toast.LENGTH_SHORT
        ).show()

        viewModelScope.launch(Dispatchers.IO) {
            product = LocalDataBase.getInstance().getProductDao().getProductByEId(productId)
        }
    }


}

enum class ProductScreenState {
    Create,
    Update
}