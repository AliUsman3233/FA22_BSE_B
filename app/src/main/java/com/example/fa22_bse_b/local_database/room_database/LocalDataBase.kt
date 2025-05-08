package com.example.fa22_bse_b.local_database.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fa22_bse_b.local_database.dao.LoginDao
import com.example.fa22_bse_b.login_migrated.model.LoginEntity

@Database(entities = [LoginEntity::class], version = 1)
abstract class LocalDataBase : RoomDatabase() {
    abstract fun getLoginDao(): LoginDao


    companion object {
        var instance: LocalDataBase? = null

        fun getInstance(context: Context): LocalDataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context = context,
                    klass = LocalDataBase::class.java,
                    name = "FA22_BSE_B"
                ).build()
            }
            return instance!!
        }

    }

}