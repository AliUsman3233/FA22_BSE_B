package com.example.fa22_bse_b.cart.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.fa22_bse_b.prodcuts_migrated.model.ProductEntityMigrated

// Model Layer

@Entity(tableName = "cart_table", primaryKeys = ["id"])
data class CartItemEntity(
    var id: String = "",
    var imageUrl: String? = "",
    var desc: String? = "",
    var company: String? = "",
    var price: String? = "",
    var discount: String? = "",
    var quantity: Int,
    var cartItemState: Boolean
)
