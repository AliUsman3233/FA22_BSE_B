package com.example.fa22_bse_b.local_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fa22_bse_b.cart.model.CartItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {

    @Insert
    fun addCartItem(cartItemEntity: CartItemEntity)

    @Query("select * from cart_table")
    fun getAllCartItems(): Flow<List<CartItemEntity>>


    @Query("select * from cart_table where id=:id LIMIT 1")
    fun getCartItemById(id: String): CartItemEntity

    @Update
    fun updateCartItem(cartItemEntity: CartItemEntity)

    @Delete
    fun deleteCartItem(cartItem: CartItemEntity)
}