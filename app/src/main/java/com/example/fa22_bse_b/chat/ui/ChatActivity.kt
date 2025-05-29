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
            chatViewModel.to = intent?.extras?.getString("to")
            chatViewModel.from = intent?.extras?.getString("from")
        }

        chatAdopter = ChatAdopter(chatViewModel = chatViewModel)
        binding?.chatRv?.adapter = chatAdopter
        binding?.chatRv?.layoutManager = LinearLayoutManager(this)
        chatViewModel.filteredChat.observe(this) { allChats ->
            chatAdopter?.submitList(allChats)
            chatAdopter?.notifyDataSetChanged()
        }





    //        val messageData = getChatData()
//        chatAdopter?.submitList(messageData)
//        chatAdopter?.notifyDataSetChanged()

//        lifecycleScope.launch(Dispatchers.IO) {
//            delay(10000)
//            messageData[messageData.size - 1] = messageData.getOrNull(messageData.size - 1)?.apply {
//                messageStatus = MessageStatus.SEEN
//            }
//            withContext(Dispatchers.Main) {
//                chatAdopter?.submitList(messageData)
//                chatAdopter?.notifyItemChanged(messageData.size - 1)
//            }
//        }
    }


//    fun getChatData() = mutableListOf<ChatModel?>(
//        ChatModel(
//            message = "Hi, How Are you?",
//            time = "9:55 AM",
//            messageStatus = MessageStatus.SEEN,
//            messageType = MessageType.SENDER
//        ),
//        ChatModel(
//            message = "I am fine, What about you?",
//            time = "9:56 AM",
//            messageType = MessageType.RECEIVER
//        ),
//        ChatModel(
//            message = "I am Good, What are you doing?",
//            time = "9:57 AM",
//            messageStatus = MessageStatus.SEEN,
//            messageType = MessageType.SENDER
//        ),
//        ChatModel(
//            message = "I am studying Mobile Application Development",
//            time = "9:58 AM",
//            messageType = MessageType.RECEIVER
//        ),
//        ChatModel(
//            message = "Best of luck",
//            time = "11:00 AM",
//            messageStatus = MessageStatus.SENT,
//            messageType = MessageType.SENDER
//        )
//    )
}
