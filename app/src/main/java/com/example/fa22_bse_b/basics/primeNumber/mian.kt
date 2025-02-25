package com.example.fa22_bse_b.basics.primeNumber

import java.util.Scanner

fun main() {

    println("Here we are --  In prime number")

    print("Enter a number : ")
    val enteredNumber: Int = Scanner(System.`in`).nextLine().toInt()
    var primeState = true
    for(i in 2..enteredNumber-1) {
        if(enteredNumber%i == 0){
            primeState = false
        }
    }

    if(primeState == true) {
        println("$enteredNumber is prime")
    } else {
        println("$enteredNumber is not prime")
    }
//    println("$enteredNumber is ${if (!primeState) "not" else ""} prime")


}