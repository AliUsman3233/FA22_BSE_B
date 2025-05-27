package com.example.fa22_bse_b.chat.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.chat.model.ChatModel
import com.example.fa22_bse_b.chat.model.MessageStatus
import com.example.fa22_bse_b.chat.model.MessageType
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    val messageMLD: MutableLiveData<String> = MutableLiveData("")

    val refreshChatDataMLD: MutableLiveData<Unit> = MutableLiveData()
    val chatDataLD: LiveData<List<ChatModel>> = refreshChatDataMLD.switchMap {
        LocalDataBase.getInstance().getChatDao().getAllChats().asLiveData()
    }

    init {
        refreshChatDataMLD.value = Unit
    }


    fun sendMessage() {

        viewModelScope.launch(Dispatchers.IO) {
            val message = ChatModel(
                id = System.currentTimeMillis().toString(),
                message = messageMLD.value?:"",
                time = System.currentTimeMillis().toString(),
                messageStatus = MessageStatus.SENT,
                messageType = MessageType.SENDER
            )
            LocalDataBase.getInstance().getChatDao().sendMessage(message)
            messageMLD.postValue("")
            refreshChatDataMLD.postValue(Unit)
        }

    }

}