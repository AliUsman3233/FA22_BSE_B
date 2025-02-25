package com.example.fa22_bse_b.basics.controlStatment.main

import com.example.fa22_bse_b.basics.controlStatment.model.Student
import java.util.Scanner

fun main() {
    println("We are here -- ControlStatments")

    val studentList: MutableList<Student> = mutableListOf(
        Student(name = "Ali", age = 30, rollNo = "FA21-60"),
        Student(name = "Bilal", age = 29, rollNo = "SP22-60"),
        Student(name = "Tahir", age = 15, rollNo = "FA21-50"),
        Student(name = "Kashif", age = 27, rollNo = "SP21-70"),
        Student(name = "Saad", age = 26, rollNo = "FA22-80"),
    )

//    println("Enter name you want to search")
//    val nameToSearch = Scanner(System.`in`).nextLine()

    val foundObject = studentList.filter { search(it) }
    print("Found object  = ${foundObject}")

//    var searchState: Boolean = false
//    for (i in 0..studentList.size - 1) {
//        if (studentList.get(i).name == nameToSearch) {
//            searchState = true
//        }
//    }
//
//    if (searchState == true) {
//        println("Student with name $nameToSearch is found")
//    } else {
//        println("No record found with name  = $nameToSearch")
//    }


//
//    val a: Int = 20
//    val b: Int = 30
//
//    if (a < b && "Pakistan".contains("P") && 10 == 10) {
//        println("A is greater")
//    } else {
//        println("B is greater")
//    }
}

fun search(student: Student): Boolean {
    return student.name.contains("i") && student.age > 20
}