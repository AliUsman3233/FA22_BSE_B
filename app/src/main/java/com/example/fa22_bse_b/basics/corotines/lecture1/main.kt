package com.example.fa22_bse_b.basics.corotines.lecture1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    val startTime = System.currentTimeMillis()

    runBlocking {
//        delay(1000)
        launch {
            add()
        }
//        delay(500)
        launch {
            sub()
        }
//        delay(2500)
        launch {
            downloadFile()
        }
//        delay(2500)
        launch {
            task()
        }
    }

    val endTime = System.currentTimeMillis()
    println("Time taken: ${(endTime.toDouble() - startTime.toDouble()) / 1000.0} s")
}

suspend fun add(): Int {
    delay(2000)
    return 2 + 5;
}

suspend fun sub(): Int {
    delay(2000)
    return 2 - 5;
}

suspend fun downloadFile(): String {
    delay(4000)
    return "file.png"
}

suspend fun task(): String {
    delay(3500)
    return "task";
}