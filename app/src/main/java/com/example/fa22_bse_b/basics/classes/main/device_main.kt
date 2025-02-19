package com.example.fa22_bse_b.basics.classes.main

import com.example.fa22_bse_b.basics.classes.model.Device
import java.util.Scanner

fun main() {
    println("Here we are --- DeviceMain")

    val device1: Device = Device("Electric",2000,"2025","Black")
    val device2: Device = Device(price = 1000, color = "Red", type = "ABC", modelYear = "2020")

    displayDevice(device1)
    device2.displayDevice()

    val userCreatedDevice: Device = createDevice()
    userCreatedDevice.displayDevice()
}

fun displayDevice(device: Device) {
    println("Device : type: ${device.type}, price: ${device.price}, modelYear: ${device.modelYear}, color: ${device.color}")
}

fun createDevice(): Device {

    val t: String
    val p: Int
    val m: String
    val c: String
    val sc: Scanner = Scanner(System.`in`)
    println("Enter Device Type")
    t = sc.nextLine()
    println("Enter Device Price")
    p = sc.nextLine().toInt()
    println("Enter Device Model Year")
    m = sc.nextLine()
    println("Enter color")
    c = sc.nextLine()

    val newDevice: Device = Device(type = t, price = p, modelYear = m, color = c)
    return newDevice

}