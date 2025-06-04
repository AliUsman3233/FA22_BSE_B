package com.example.fa22_bse_b.chat.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fa22_bse_b.chat.model.ChatModel
import kotlinx.coroutines.flow.Flow

interface ChatRepositoryInterface {

    val messageMLD: MutableLiveData<String>
    var to: String?
    var from: String?
    val refreshChatDataMLD: MutableLiveData<Unit>

    val chatDataLD: LiveData<List<ChatModel>>

    val filteredChat: LiveData<List<ChatModel>>

    val filterChatsCurrentlySent: LiveData<List<ChatModel>>

    fun getAllChats(): Flow<List<ChatModel>>

    fun getAllChatsWithPersonAndSetStatusAsDelivered(_to: String, _from: String)

    fun setMessageAsDelivered(messageId: String)

    fun setMessageAsSeen(messageId: String)

    fun sendMessage()
}