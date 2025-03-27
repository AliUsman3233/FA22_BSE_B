package com.example.fa22_bse_b.prodcuts.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.ProductListScreenBinding
import com.example.fa22_bse_b.prodcuts.adopter.ProductsAdopter
import com.example.fa22_bse_b.prodcuts.model.Product

class ProductsActivity : AppCompatActivity() {

    var binding: ProductListScreenBinding? = null
    var productListAdopter: ProductsAdopter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.product_list_screen)

        val productsList: MutableList<Product> = arrayListOf(
            Product(
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 1",
                company = "XYZ",
                price = 200.0,
                discount = 5.0,
                quantity = 2
            ),
            Product(
                imageUrl =
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 2",
                company = "ABC",
                price = 300.0,
                discount = 6.0,
                quantity = 20
            ),
            Product(
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 3",
                company = "JKBCSUII",
                price = 900.0,
                discount = 4.0,
                quantity = 10
            ),
            Product(
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 4",
                company = "NJSNOIS",
                price = 10000.0,
                discount = 2.0,
                quantity = 8
            ),
            Product(
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 5",
                company = "QWERTY",
                price = 10.0,
                discount = 0.01,
                quantity = 5
            ),
            Product(
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 6",
                company = "XYZ",
                price = 800.0,
                discount = 1.0,
                quantity = 3
            ),
            Product(
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 7",
                company = "TYUIO",
                price = 423.0,
                discount = 9.5,
                quantity = 5
            ),
            Product(
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fclock&psig=AOvVaw2izIh24c6zyivRrXyJcpta&ust=1743045315136000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIiS_4HkpowDFQAAAAAdAAAAABAE",
                desc = "Clock 8",
                company = "XYZ",
                price = 700.0,
                discount = 6.0,
                quantity = 7
            )
        )


        productListAdopter = ProductsAdopter()


        binding?.productRv?.adapter = productListAdopter
        binding?.productRv?.layoutManager = LinearLayoutManager(this)
        productListAdopter?.submitList(productsList)
        productListAdopter?.notifyDataSetChanged()
        Log.e(this@ProductsActivity.javaClass.simpleName, "onCreate: List = $productsList", )
    }
}