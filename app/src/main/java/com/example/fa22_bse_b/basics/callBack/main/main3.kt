package com.example.fa22_bse_b.basics.callBack.main

fun main() {

    showName(Student(name = "ABC", age = 20, phoneNumber = "345678", marks = 20, gender = false),
        displayCallBack = {
            println("Student = $it")
        })


}

fun showName(student: Student, displayCallBack: (Student) -> Unit) {
    if (student.name != "") {
        displayCallBack.invoke(student)
    }
}