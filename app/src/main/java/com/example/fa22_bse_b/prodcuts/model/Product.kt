package com.example.fa22_bse_b.prodcuts.model

// Model Layer
data class Product(
    var id: String = "",
    var imageUrl: String? = "",
    var desc: String? = "",
    var company: String? = "",
    var price: String? = "",
    var discount: String? = "",
    var quantity: String? = ""
)
