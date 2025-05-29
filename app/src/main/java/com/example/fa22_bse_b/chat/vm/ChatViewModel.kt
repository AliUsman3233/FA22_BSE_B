package com.example.fa22_bse_b.chat.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.chat.model.ChatModel
import com.example.fa22_bse_b.chat.model.MessageStatus
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    var to: String? = null
    var from: String? = null
    val messageMLD: MutableLiveData<String> = MutableLiveData("")

    val refreshChatDataMLD: MutableLiveData<Unit> = MutableLiveData()
    val chatDataLD: LiveData<List<ChatModel>> = refreshChatDataMLD.switchMap {
        LocalDataBase.getInstance().getChatDao().getAllChats().asLiveData()
    }

    val filteredChat = chatDataLD.map { chatData ->
        chatData.filter { message -> (message.to == to && message.from == from) || (message.from == to && message.to == from) }
    }

    val filterChatsCurrentlySent = filteredChat.map { filteredMessages ->
        filteredMessages.filter { it.messageStatus == MessageStatus.SENT && it.to == from }
    }


    fun getAllChatsWithPersonAndSetStatusAsDelivered(_to: String, _from: String) {
        viewModelScope.launch(Dispatchers.IO) {
            LocalDataBase.getInstance().getChatDao().getAllChats().collect { allChats ->
                allChats.filter { message -> (message.to == _to && message.from == _from) }
                    .forEach { message ->
                        if (message.messageStatus == MessageStatus.SENT) {
                            setMessageAsDelivered(messageId = message.id)
                        }
                    }
            }
        }

    }


    init {
        refreshChatDataMLD.value = Unit
    }


    fun sendMessage() {

        viewModelScope.launch(Dispatchers.IO) {
            val message = ChatModel(
                id = System.currentTimeMillis().toString(),
                message = messageMLD.value ?: "",
                time = System.currentTimeMillis().toString(),
                messageStatus = MessageStatus.SENT,
                from = from ?: "",
                to = to ?: ""
            )
            LocalDataBase.getInstance().getChatDao().sendMessage(message)
            messageMLD.postValue("")
            refreshChatDataMLD.postValue(Unit)
        }

    }


    fun setMessageAsSeen(messageId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val message =
                LocalDataBase.getInstance().getChatDao().getMessageById(messageId = messageId)
            LocalDataBase.getInstance().getChatDao()
                .updateMessage(message.apply { messageStatus = MessageStatus.SEEN })
            refreshChatDataMLD.postValue(Unit)
        }
    }

    fun setMessageAsDelivered(messageId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val message =
                LocalDataBase.getInstance().getChatDao().getMessageById(messageId = messageId)
            LocalDataBase.getInstance().getChatDao()
                .updateMessage(message.apply { messageStatus = MessageStatus.DELIVERED })
            refreshChatDataMLD.postValue(Unit)
        }
    }

}