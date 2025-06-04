package com.example.fa22_bse_b.chat.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.chat.adopter.ChatAdopter
import com.example.fa22_bse_b.chat.model.ChatModel
import com.example.fa22_bse_b.chat.model.MessageStatus
import com.example.fa22_bse_b.chat.model.MessageType
import com.example.fa22_bse_b.chat.vm.ChatViewModel
import com.example.fa22_bse_b.databinding.ActivityChatBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatActivity : AppCompatActivity() {
    var binding: ActivityChatBinding? = null
    var chatAdopter: ChatAdopter? = null
    val chatViewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding?.chatViewModel = chatViewModel
        binding?.lifecycleOwner = this

        if(intent.extras != null) {
            chatViewModel.chatRepo.to = intent?.extras?.getString("to")
            chatViewModel.chatRepo.from = intent?.extras?.getString("from")
        }

        chatAdopter = ChatAdopter(chatViewModel = chatViewModel)
        binding?.chatRv?.adapter = chatAdopter
        binding?.chatRv?.layoutManager = LinearLayoutManager(this)
        chatViewModel.chatRepo.filteredChat.observe(this) { allChats ->
            chatAdopter?.submitList(allChats)
            chatAdopter?.notifyDataSetChanged()
        }
    }

}
