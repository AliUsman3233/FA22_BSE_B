package com.example.fa22_bse_b.multipletype.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.ActivityCarsBinding
import com.example.fa22_bse_b.multipletype.adopter.CarAdopter
import com.example.fa22_bse_b.multipletype.model.ElectricCar
import com.example.fa22_bse_b.multipletype.model.HybridLIstItem
import com.example.fa22_bse_b.multipletype.model.PetrolCar

class CarsActivity : AppCompatActivity() {

    var binding: ActivityCarsBinding? = null

    var carAdopter: CarAdopter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cars)
        carAdopter = CarAdopter()
        binding?.carsRv?.adapter = carAdopter
        binding?.carsRv?.layoutManager = LinearLayoutManager(this)

        val carsList: MutableList<HybridLIstItem> = arrayListOf(
            HybridLIstItem(petrolCar = PetrolCar(name = "Mehran", model = "2010")),
            HybridLIstItem(electricCar = ElectricCar(name = "Tesla", model = "2012", batteryPower = "200000")),
                    HybridLIstItem(petrolCar = PetrolCar(name = "Cultus", model = "2014")),
            HybridLIstItem(electricCar = ElectricCar(name = "MG", model = "2012", batteryPower = "400000")),
                    HybridLIstItem(petrolCar = PetrolCar(name = "Honda", model = "2022"))

        )

        carAdopter?.submitList(carsList)
        carAdopter?.notifyDataSetChanged()

    }
}