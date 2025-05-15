package com.example.fa22_bse_b.prodcuts_migrated.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.cart.viewmodel.CartViewModel
import com.example.fa22_bse_b.databinding.ProductListScreenMigratedBinding
import com.example.fa22_bse_b.prodcuts_migrated.adopter.ProductsAdopterMigrated
import com.example.fa22_bse_b.prodcuts_migrated.view_model.ProductsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//UI Layer
class ProductsActivityMigrated : AppCompatActivity() {

    var binding: ProductListScreenMigratedBinding? = null
    var productListAdopter: ProductsAdopterMigrated? = null
    val productsViewModel: ProductsViewModel by viewModels()
    val cartViewModel: CartViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.product_list_screen_migrated)
        binding?.viewmodel = productsViewModel
        binding?.cartViewModel = cartViewModel
        binding?.lifecycleOwner = this

        productListAdopter = ProductsAdopterMigrated(viewModel = productsViewModel, cartViewModel = cartViewModel)
        binding?.productRv?.adapter = productListAdopter
        binding?.productRv?.layoutManager = LinearLayoutManager(this)


        productsViewModel.navigateToAddProductMLD.observe(this) {
            if (it == true) {
                Toast.makeText(this, "Navigating to Add Product Screen", Toast.LENGTH_SHORT).show()
                lifecycleScope.launch(Dispatchers.IO) {
                    delay(500)
                    startActivity(
                        Intent(
                            this@ProductsActivityMigrated,
                            AddOrUpdateProductMigrated::class.java
                        )
                    )
                }
            }
        }

        productsViewModel.navigateToUpdateProductMLD.observe(this) { productId ->
            if (productId != null) {
                Toast.makeText(this, "Navigating to Update Product Screen", Toast.LENGTH_SHORT).show()
                lifecycleScope.launch(Dispatchers.IO) {
                    delay(500)
                    startActivity(
                        Intent(
                            this@ProductsActivityMigrated,
                            AddOrUpdateProductMigrated::class.java
                        ).putExtra("ProductId", productId)
                    )
                }
            }
        }


        productsViewModel.productListLD.observe(this) { allProducts ->

            Log.e("ProductsActivityMigrated", "onCreate: allProducts = ${allProducts}")
            productListAdopter?.submitList(allProducts)
            productListAdopter?.notifyDataSetChanged()
        }

        cartViewModel.cartItemsList.observe(this) { cartItemsList ->
            Log.e("ProductsActivityMigrated", "cartItemsList: $cartItemsList", )
        }


//
//        productsList.addAll(arrayListOf(
//            Product(
//                id = "101",
//                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 1",
//                company = "XYZ",
//                price = 200.0.toString(),
//                discount = 5.0.toString(),
//                quantity = 2.toString()
//            ),
//            Product(
//                id = "102",
//                imageUrl =
//                "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 2",
//                company = "ABC",
//                price = 300.0.toString(),
//                discount = 6.0.toString(),
//                quantity = 20.toString()
//            ),
//            Product(
//                id = "103",
//                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 3",
//                company = "JKBCSUII",
//                price = 900.0.toString(),
//                discount = 4.0.toString(),
//                quantity = 10.toString()
//            ),
//            Product(
//                id = "104",
//                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 4",
//                company = "NJSNOIS",
//                price = 10000.0.toString(),
//                discount = 2.0.toString(),
//                quantity = 8.toString()
//            ),
//            Product(
//                id = "105",
//                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 5",
//                company = "QWERTY",
//                price = 10.0.toString(),
//                discount = 0.01.toString(),
//                quantity = 5.toString()
//            ),
//            Product(
//                id = "106",
//                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 6",
//                company = "XYZ",
//                price = 800.0.toString(),
//                discount = 1.0.toString(),
//                quantity = 3.toString()
//            ),
//            Product(
//                id = "107",
//                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 7",
//                company = "TYUIO",
//                price = 423.0.toString(),
//                discount = 9.5.toString(),
//                quantity = 5.toString()
//            ),
//            Product(
//                id = "108",
//                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
//                desc = "Clock 8",
//                company = "XYZ",
//                price = 700.0.toString(),
//                discount = 6.0.toString(),
//                quantity = 7.toString()
//            )
//        ))
//
//

//
//

//        productListAdopter?.submitList(productsList)
//        productListAdopter?.notifyDataSetChanged()
//        Log.e(this@ProductsActivityMigrated.javaClass.simpleName, "onCreate: List = $productsList")
//
//
//
//        binding?.addBtn?.setOnClickListener {
//            SystemState.product = null
//            startActivity(Intent(this@ProductsActivityMigrated, AddOrUpdateProduct::class.java))
//        }
    }


    override fun onResume() {
        super.onResume()
//        if(SystemState.product != null) {
//            if(productsList.find { it.id == SystemState.product?.id } == null) {
//                productsList.add(SystemState.product!!)
//                productListAdopter?.submitList(productsList)
//                productListAdopter?.notifyDataSetChanged()
//            } else {
//                val oldLocation = productsList.indexOf(productsList.find { it.id == SystemState.product?.id })
//                productsList[oldLocation] = SystemState.product!!
//                productListAdopter?.submitList(productsList)
//                productListAdopter?.notifyItemChanged(oldLocation)
//            }
//
//        }
    }
}