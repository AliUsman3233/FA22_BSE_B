package com.example.fa22_bse_b.prodcuts.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_b.databinding.UserRowDesignBinding

// Ui Layer
class UsersAdopter(val onUserClickCallBack: (String) -> Unit) :
    ListAdapter<String, UsersAdopter.UserViewHolder>(diffCheker2) {


    inner class UserViewHolder(var binding: UserRowDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: UserRowDesignBinding = UserRowDesignBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UserViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, index: Int) {
        val dataItem = getItem(index)
        holder.binding.userEmail.setText(dataItem)
        holder.binding.root.setOnClickListener {
            onUserClickCallBack.invoke(dataItem)
        }

    }


}

val diffCheker2 = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return false
    }

}