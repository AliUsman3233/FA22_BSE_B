package com.example.fa22_bse_b.prodcuts.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_b.databinding.ProductRowDesignBinding
import com.example.fa22_bse_b.prodcuts.model.Product

class ProductsAdopter(
    var deleteProductCallBack: (String) -> Unit,
    var updateProductCallBack: (String) -> Unit
) : ListAdapter<Product, ProductsAdopter.ProductViewHolder>(diffCheker) {


    inner class ProductViewHolder(var productRowBinding: ProductRowDesignBinding) :
        RecyclerView.ViewHolder(productRowBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productRowBinding: ProductRowDesignBinding = ProductRowDesignBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(productRowBinding = productRowBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, index: Int) {
        val dataItem = getItem(index)
        holder.productRowBinding.product = dataItem

        holder.productRowBinding.deleteBtn.setOnClickListener {
            deleteProductCallBack.invoke(dataItem.id)
        }

        holder.productRowBinding.UpdateBtn.setOnClickListener {
            updateProductCallBack.invoke(dataItem.id)
        }
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