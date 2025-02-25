package com.example.fa22_bse_b.basics.fictorial

import java.util.Scanner

fun main() {
    println("Here we are --  In Factorial")
    print("Enter a number : ")
    val num: Int = Scanner(System.`in`).nextLine().toInt()
//    var fact = 1
//    for(i in (1..num).toList().reversed()) {
//        fact = fact * i
//    }
    print("factorial  = ${factorial(num)} ")
}

fun factorial(num: Int): Int {
    if(num > 1) {
        return num * factorial(num -1)
    } else {
        return 1
    }
}
