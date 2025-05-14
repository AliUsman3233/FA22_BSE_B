package com.example.fa22_bse_b.local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.fa22_bse_b.cart.model.CartItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {

    @Insert
    fun addCartItem(cartItemEntity: CartItemEntity)

    fun getAllCartItems(): Flow<List<CartItemEntity>>


}