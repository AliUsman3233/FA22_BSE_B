package com.example.fa22_bse_b.basics

fun main() {

    val x = 10
    val y = 20
//    val result = sum(b = x, a = y)
//    print("Sum  = $result")
    println("Sum  = ${sum(b = x, a = y)}")
    println("Is Adult : ${agerFilter(18)}")
    println("You are ${agerFilter(22.0)}")
}
fun sum(a:Int, b:Int):Int {
    return a+b
}

fun agerFilter(age: Int): Boolean {
    return age<=20
}

fun agerFilter(age: Double): String {
    if (age<=20) {
        return "Adult"
    } else {
        return "Not Adult"
    }
}

/*
fun FunctionName(variableName:VariableType....):ReturnType {

}

int sum(int a, int b) {
    return a + b
}
*/