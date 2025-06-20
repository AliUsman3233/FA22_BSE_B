package com.example.fa22_bse_b.local_database.room_database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fa22_bse_b.FA22_BSE_Application
import com.example.fa22_bse_b.cart.model.CartItemEntity
import com.example.fa22_bse_b.chat.model.ChatModel
import com.example.fa22_bse_b.local_database.dao.CartItemDao
import com.example.fa22_bse_b.local_database.dao.ChatDao
import com.example.fa22_bse_b.local_database.dao.LoginDao
import com.example.fa22_bse_b.local_database.dao.ProductDao
import com.example.fa22_bse_b.login_migrated.model.LoginEntity
import com.example.fa22_bse_b.prodcuts_migrated.model.ProductEntityMigrated

@Database(
    entities = [LoginEntity::class, ProductEntityMigrated::class, CartItemEntity::class, ChatModel::class],
    version = 1
)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun getLoginDao(): LoginDao
    abstract fun getProductDao(): ProductDao
    abstract fun getCartItemDao(): CartItemDao
    abstract fun getChatDao(): ChatDao


    companion object {
        var instance: LocalDataBase? = null

        @JvmName("getInstanceABC")
        fun getInstance(): LocalDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context = FA22_BSE_Application.context!!,
                    klass = LocalDataBase::class.java,
                    name = "FA22_BSE_B"
                ).build()
            }
            return instance!!
        }

    }

}