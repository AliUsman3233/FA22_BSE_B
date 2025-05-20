package com.example.fa22_bse_b.cart.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_b.cart.model.CartItemEntity
import com.example.fa22_bse_b.databinding.BillItemRowBinding

// Ui Layer
class CartAdopterMigrated() :
    ListAdapter<CartItemEntity, CartAdopterMigrated.CartItemViewHolder>(diffCheker) {


    inner class CartItemViewHolder(var binding: BillItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val binding: BillItemRowBinding =
            BillItemRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return CartItemViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, index: Int) {
        val dataItem = getItem(index)

        holder.binding.cartItem = dataItem

        holder.binding.totalPrice.setText(
            (dataItem.quantity.toDouble() * (dataItem.price?.toDouble() ?: 0.0)).toString()
        )
    }


}

val diffCheker = object : DiffUtil.ItemCallback<CartItemEntity>() {
    override fun areItemsTheSame(
        oldItem: CartItemEntity,
        newItem: CartItemEntity
    ): Boolean {
        return false
    }

    override fun areContentsTheSame(
        oldItem: CartItemEntity,
        newItem: CartItemEntity
    ): Boolean {
        return false
    }

}