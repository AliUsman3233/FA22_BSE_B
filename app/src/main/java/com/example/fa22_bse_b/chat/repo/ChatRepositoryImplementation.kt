package com.example.fa22_bse_b.chat.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.example.fa22_bse_b.chat.model.ChatModel
import com.example.fa22_bse_b.chat.model.MessageStatus
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ChatRepositoryImplementation : ChatRepositoryInterface {

    override val messageMLD: MutableLiveData<String> = MutableLiveData()
    override var to: String? = null
    override var from: String? = null


    override val refreshChatDataMLD: MutableLiveData<Unit> = MutableLiveData()
    override val chatDataLD: LiveData<List<ChatModel>> = refreshChatDataMLD.switchMap {
        getAllChats().asLiveData()
    }

    override val filteredChat: LiveData<List<ChatModel>> = chatDataLD.map { chatData ->
        chatData.filter { message -> (message.to == to && message.from == from) || (message.from == to && message.to == from) }
    }

    override val filterChatsCurrentlySent: LiveData<List<ChatModel>> =
        filteredChat.map { filteredMessages ->
            filteredMessages.filter { it.messageStatus == MessageStatus.SENT && it.to == from }
        }

    init {
        refreshChatDataMLD.value = Unit
    }

    override fun getAllChats(): Flow<List<ChatModel>> {
        return LocalDataBase.getInstance().getChatDao().getAllChats()
    }

    override fun getAllChatsWithPersonAndSetStatusAsDelivered(_to: String, _from: String) {
        CoroutineScope(Dispatchers.IO).launch {
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

    override fun setMessageAsDelivered(messageId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val message =
                LocalDataBase.getInstance().getChatDao().getMessageById(messageId = messageId)
            LocalDataBase.getInstance().getChatDao()
                .updateMessage(message.apply { messageStatus = MessageStatus.DELIVERED })
        }
    }

    override fun setMessageAsSeen(messageId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val message =
                LocalDataBase.getInstance().getChatDao().getMessageById(messageId = messageId)
            LocalDataBase.getInstance().getChatDao()
                .updateMessage(message.apply { messageStatus = MessageStatus.SEEN })
        }
    }

    override fun sendMessage() {

        CoroutineScope(Dispatchers.IO).launch {
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

}