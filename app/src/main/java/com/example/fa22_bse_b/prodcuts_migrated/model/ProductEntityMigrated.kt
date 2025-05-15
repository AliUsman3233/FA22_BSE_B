package com.example.fa22_bse_b.prodcuts_migrated.model

import androidx.room.ColumnInfo
import androidx.room.Entity

// Model Layer

@Entity(tableName = "product_table", primaryKeys = ["id"])
data class ProductEntityMigrated(
    var id: String = "",
    var imageUrl: String? = "",
    var desc: String? = "",
    var company: String? = "",
    var price: String? = "",
    var discount: String? = "",
)
