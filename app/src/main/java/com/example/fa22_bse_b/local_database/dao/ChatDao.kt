package com.example.fa22_bse_b.local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fa22_bse_b.chat.model.ChatModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Query("select * from chat_table")
    fun getAllChats(): Flow<List<ChatModel>>

    @Insert
    fun sendMessage(chatModel: ChatModel)
}