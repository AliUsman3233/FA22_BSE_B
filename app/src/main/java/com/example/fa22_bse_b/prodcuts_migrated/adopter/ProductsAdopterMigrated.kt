package com.example.fa22_bse_b.prodcuts_migrated.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_b.databinding.ProductRowDesignMigratedBinding
import com.example.fa22_bse_b.prodcuts_migrated.model.ProductEntityMigrated
import com.example.fa22_bse_b.prodcuts_migrated.view_model.ProductsViewModel

// Ui Layer
class ProductsAdopterMigrated(val viewModel: ProductsViewModel) :
    ListAdapter<ProductEntityMigrated, ProductsAdopterMigrated.ProductViewHolder>(diffCheker) {


    inner class ProductViewHolder(var productRowBinding: ProductRowDesignMigratedBinding) :
        RecyclerView.ViewHolder(productRowBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productRowBinding: ProductRowDesignMigratedBinding =
            ProductRowDesignMigratedBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ProductViewHolder(productRowBinding = productRowBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, index: Int) {
        val dataItem = getItem(index)
        holder.productRowBinding.product = dataItem
        holder.productRowBinding.viewModel = viewModel
        holder.productRowBinding.deleteBtn.setOnClickListener {
            viewModel.removeProduct(dataItem.id)
        }

//
        holder.productRowBinding.UpdateBtn.setOnClickListener {
            viewModel.updateProduct(dataItem.id)

//            updateProductCallBack.invoke(dataItem.id)
        }
//        holder.productRowBinding.price.setText(dataItem.price.toString())
    }


}

val diffCheker = object : DiffUtil.ItemCallback<ProductEntityMigrated>() {
    override fun areItemsTheSame(
        oldItem: ProductEntityMigrated,
        newItem: ProductEntityMigrated
    ): Boolean {
        return false
    }

    override fun areContentsTheSame(
        oldItem: ProductEntityMigrated,
        newItem: ProductEntityMigrated
    ): Boolean {
        return false
    }

}