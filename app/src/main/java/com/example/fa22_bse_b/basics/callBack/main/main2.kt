package com.example.fa22_bse_b.basics.callBack.main


data class Student(
    val name: String,
    val age: Int,
    val phoneNumber: String,
    val marks: Int,
    val gender: Boolean
)

fun main() {

//    val name = ""
//    verifyName(name = name, validCallBack = {
//        println("Your name is Valid")
//    }, invalidCallBack = {
//        println("Your name is Invalid")
//    })

    val student = Student(name = "Awais", age = 20, phoneNumber = "1234567", marks = -20, gender = false)
    verifyStudent(student = student, validNameCallBack = { message ->
        println(message)
    }, invalidNameCallBack = { message ->
        println(message)
    }, passCallBack = { message ->
        println(message)
    }, failCallBack = { message ->
        println(message)
    }, invalidMarksCallBack = { message ->
        println(message)
    })

}


fun verifyName(name: String, validCallBack: () -> Unit, invalidCallBack: () -> Unit) {
    if (name == "") {
        invalidCallBack.invoke()
    } else {
        validCallBack.invoke()
    }
}

fun verifyStudent(
    student: Student,
    validNameCallBack: (String) -> Unit,
    invalidNameCallBack: (String) -> Unit,
    passCallBack: (String) -> Unit,
    failCallBack: (String) -> Unit,
    invalidMarksCallBack: (String) -> Unit
) {
    if (student.name.isEmpty()) {
        invalidNameCallBack.invoke("'${student.name}' is a Invalid name")
    } else {
        validNameCallBack.invoke("'${student.name}' is a valid name")
    }
    if (student.marks > 49) {
        passCallBack.invoke("'${student.name}' has passed with '${student.marks}'")
    } else if (student.marks < 0) {
        invalidMarksCallBack.invoke("Marks entered as '${student.marks}' for student ${student.name} are not valid marks")
    } else {
        failCallBack.invoke("'${student.name}' has failed with '${student.marks}'")
    }
}