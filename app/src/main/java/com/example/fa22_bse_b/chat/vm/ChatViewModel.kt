package com.example.fa22_bse_b.chat.vm

import androidx.lifecycle.ViewModel
import com.example.fa22_bse_b.chat.repo.ChatRepositoryImplementation
import com.example.fa22_bse_b.chat.repo.ChatRepositoryInterface

class ChatViewModel() : ViewModel() {

    val chatRepo: ChatRepositoryInterface = ChatRepositoryImplementation()

}