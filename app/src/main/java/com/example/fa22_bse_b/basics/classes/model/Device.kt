package com.example.fa22_bse_b.basics.classes.model

data class Device(
    val type: String,
    val price: Int,
    val modelYear: String,
    val color: String
) {
    fun displayDevice() {
        println("Device : type: ${type}, price: ${price}, modelYear: ${modelYear}, color: ${color}")
    }
}