package com.example.fa22_bse_b.prodcuts.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_b.databinding.ProductRowDesignBinding
import com.example.fa22_bse_b.prodcuts.model.Product

class ProductsAdopter : ListAdapter<Product, ProductsAdopter.ProductViewHolder>(diffCheker) {


    inner class ProductViewHolder(var productRowBinding: ProductRowDesignBinding) :
        RecyclerView.ViewHolder(productRowBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productRowBinding: ProductRowDesignBinding = ProductRowDesignBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(productRowBinding = productRowBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, location: Int) {
        val dataItem = getItem(location)
        holder.productRowBinding.product = dataItem
//        holder.productRowBinding.price.setText(dataItem.price.toString())
    }


}

val diffCheker = object : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return false
    }

}