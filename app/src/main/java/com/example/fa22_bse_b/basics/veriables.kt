package com.example.fa22_bse_b.basics


fun main() {
//    print("Mobile Application Development")

//    int a = 30;
    var a:Int? = 60  // nullable
    var b:Int? = null

    val sum = (a?:0) + (b?:0)

    val div = (a?:0) / (b?:1) // else-wise
    print("Sum = $sum")
    print("Div = $div")

}