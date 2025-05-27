package com.example.fa22_bse_b.chat.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_b.chat.model.ChatModel
import com.example.fa22_bse_b.chat.model.MessageType
import com.example.fa22_bse_b.databinding.ReceiverMessageRowDesignBinding
import com.example.fa22_bse_b.databinding.SenderMessageRowDesignBinding

class ChatAdopter: ListAdapter<ChatModel,RecyclerView.ViewHolder>(diffChecker) {

    inner class SenderViewHolder(val binding: SenderMessageRowDesignBinding):RecyclerView.ViewHolder(binding.root) {}

    inner class ReceiverViewHolder(val binding: ReceiverMessageRowDesignBinding):RecyclerView.ViewHolder(binding.root) {}

    override fun getItemViewType(position: Int): Int {
        val data = getItem(position)
        return if(data.messageType == MessageType.SENDER) 1 else 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1) { // sender view holder
            val binding: SenderMessageRowDesignBinding = SenderMessageRowDesignBinding.inflate(
                LayoutInflater.from(parent.context),parent,false)
            return SenderViewHolder(binding = binding)
        } else { // Receiver View Holder
            val binding: ReceiverMessageRowDesignBinding = ReceiverMessageRowDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ReceiverViewHolder(binding = binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        if(data.messageType == MessageType.SENDER) {
            (holder as SenderViewHolder).binding.chatModel = data
        } else {
            (holder as ReceiverViewHolder).binding.chatModel = data
        }
    }


}



val diffChecker = object: DiffUtil.ItemCallback<ChatModel>(){
    override fun areItemsTheSame(oldItem: ChatModel, newItem: ChatModel): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: ChatModel, newItem: ChatModel): Boolean {
        return false
    }

}