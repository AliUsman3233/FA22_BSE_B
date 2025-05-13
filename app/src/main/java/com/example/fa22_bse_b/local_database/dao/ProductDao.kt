package com.example.fa22_bse_b.local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fa22_bse_b.login_migrated.model.LoginEntity
import com.example.fa22_bse_b.prodcuts.model.ProductEntity
import com.example.fa22_bse_b.prodcuts_migrated.model.ProductEntityMigrated
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("select * from product_table")
    fun getAllProducts(): Flow<List<ProductEntityMigrated>>
    // select * from tablename

    @Query("select * from product_table where id=:id LIMIT 1")
    fun getProductByEId(id: String): ProductEntityMigrated

    @Insert
    fun addProductEntity(productEntity: ProductEntityMigrated)

    @Query("delete from product_table where id=:id")
    fun deleteProductRecordById(id: String)

    @Update
    fun updateProductRecord(productEntity: ProductEntityMigrated)

}
