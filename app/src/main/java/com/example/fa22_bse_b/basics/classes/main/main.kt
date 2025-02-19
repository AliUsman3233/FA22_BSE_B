package com.example.fa22_bse_b.basics.classes.main

import com.example.fa22_bse_b.basics.classes.model.Person

fun main() {

    println("Topic -- Classes")
    val a: Int = 20
    val person1: Person = Person("Huzaifa", 20, "SWL", "234567890")
    val person2: Person = Person(name = "Ali", address = "MBD", age = 30, CNIC = "1234567")
    displayPerson(person1)
    displayPerson(person2)
}

fun displayPerson(person: Person) {
    println("Name: ${person.name}, Age: ${person.age}, Address: ${person.address}, CNIC: ${person.CNIC}")
}