package com.example.fa22_bse_b.basics.fabnocci_series

fun main() {

    println("Here we are --  In fabnocci_series")

    var firstNumber = 0
    var secondNumber = 1
    var nextNumber:Int
    print("$firstNumber, ")
    print("$secondNumber, ")
    while((firstNumber+secondNumber) < 200) {
        nextNumber = firstNumber + secondNumber
        print("$nextNumber, ")
        firstNumber = secondNumber
        secondNumber = nextNumber
    }

}