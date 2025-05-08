package com.example.fa22_bse_b.prodcuts.model

import androidx.room.Entity

// Model Layer

@Entity(tableName = "product_table", primaryKeys = ["id"])
data class ProductEntity(
    var id: String = "",
    var imageUrl: String? = "",
    var desc: String? = "",
    var company: String? = "",
    var price: String? = "",
    var discount: String? = "",
    var quantity: String? = ""
)
