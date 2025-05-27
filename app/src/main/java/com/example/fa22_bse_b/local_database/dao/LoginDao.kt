package com.example.fa22_bse_b.local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fa22_bse_b.login_migrated.model.LoginEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {

    @Query("select * from login_table")
    fun getAllLogins(): List<LoginEntity>
    // select * from tablename

    @Query("select * from login_table")
    fun getAllLoginsAsFlow(): Flow<List<LoginEntity>>

    @Query("select * from login_table where email=:email LIMIT 1")
    fun getLoginByEmail(email: String): LoginEntity

    @Insert
    fun addLoginEntity(loginEntity: LoginEntity)

    @Query("delete from login_table where email=:email")
    fun deleteLoginRecordByEmail(email: String)

    @Update
    fun updateLoginRecord(loginEntity: LoginEntity)

}
