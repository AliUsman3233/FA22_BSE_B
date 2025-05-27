package com.example.fa22_bse_b.multipletype.model

data class HybridLIstItem(
    val petrolCar: PetrolCar? = null,
    val electricCar: ElectricCar? = null

)

data class PetrolCar(
    val name: String,
    val model: String
)

data class ElectricCar(
    val name: String,
    val model: String,
    val batteryPower: String
)

