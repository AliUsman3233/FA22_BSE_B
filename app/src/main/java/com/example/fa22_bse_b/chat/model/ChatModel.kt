package com.example.fa22_bse_b.chat.model

import androidx.room.Entity


@Entity(tableName = "chat_table", primaryKeys = ["id"])
data class ChatModel(
    val id: String,
    val message: String,
    val time: String,
    var messageStatus: MessageStatus ?= null,
    val messageType: MessageType? = null,
    val to: String,
    val from: String
)


enum class MessageStatus {
    SENT,
    DELIVERED,
    SEEN,
    DELETED
}

enum class MessageType {
    SENDER,
    RECEIVER
}
