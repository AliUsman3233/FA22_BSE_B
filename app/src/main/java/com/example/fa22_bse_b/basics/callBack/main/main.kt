package com.example.fa22_bse_b.basics.callBack.main

fun main() {
    println("Here we are -- CallBack")

    downloadFile(fileUrl = "profile.png",
        startCallBack = { message ->
            println(message)
        }, inProgressCallBack = { message, progress ->
            println("$message $progress%")
        },
        completeCallBack = { message ->
            println(message)
        })


//
//    val sumResult = sum(a = 10,b = 20, callBack = {
//        println("Sum is computed")
//    })
//    println("Sum = ${sumResult}")

}

fun downloadFile(
    fileUrl: String, startCallBack: (String) -> Unit,
    inProgressCallBack: (String, Int) -> Unit,
    completeCallBack: (String) -> Unit
) {
    println("Verifying File Url : $fileUrl")
    startCallBack.invoke("Downloading the file: $fileUrl")
    for (i in 0..100) {
        if (i % 10 == 0)
            inProgressCallBack.invoke("File is downloaded", i)
    }
    completeCallBack.invoke("$fileUrl is downloaded")
}


fun sum(a: Int, b: Int, callBack: () -> Unit): Int {
    val result = a + b
    callBack.invoke()
    return result
}