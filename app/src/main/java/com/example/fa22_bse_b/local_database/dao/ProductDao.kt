package com.example.fa22_bse_b.local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fa22_bse_b.login_migrated.model.LoginEntity
import com.example.fa22_bse_b.prodcuts.model.ProductEntity

@Dao
interface ProductDao {

    @Query("select * from product_table")
    fun getAllLogins(): List<ProductEntity>
    // select * from tablename

    @Query("select * from product_table where id=:id LIMIT 1")
    fun getLoginByEId(id: String): ProductEntity

    @Insert
    fun addLoginEntity(loginEntity: ProductEntity)

    @Query("delete from product_table where id=:id")
    fun deleteLoginRecordByEmail(id: String)

    @Update
    fun updateLoginRecord(productEntity: ProductEntity)

}
