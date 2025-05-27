package com.example.fa22_bse_b.multipletype.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_b.databinding.ElectricCarItemRowBinding
import com.example.fa22_bse_b.databinding.PetrolCarItemRowBinding
import com.example.fa22_bse_b.multipletype.model.HybridLIstItem

class CarAdopter: ListAdapter<HybridLIstItem, RecyclerView.ViewHolder>(diffCheker) {


    class PetrolCarViewHolder(val binding: PetrolCarItemRowBinding): RecyclerView.ViewHolder(binding.root){
    }

    class ElectricCarViewHolder(val binding: ElectricCarItemRowBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).petrolCar != null) {
            1 // petrol
        } else {
            2 // Electric
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1) {
            val petrolCarItemRowBinding: PetrolCarItemRowBinding = PetrolCarItemRowBinding.inflate(
                LayoutInflater.from(parent.context),parent,false)
            return PetrolCarViewHolder(binding = petrolCarItemRowBinding)
        } else {
            val electricCarItemRowBinding: ElectricCarItemRowBinding = ElectricCarItemRowBinding.inflate(
                LayoutInflater.from(parent.context),parent,false)
            return ElectricCarViewHolder(binding = electricCarItemRowBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        if(getItemViewType(position) == 1) { // petrol
            (holder as PetrolCarViewHolder).binding.petrolCar = data.petrolCar
        } else { // electric
            (holder as ElectricCarViewHolder).binding.electricCar = data.electricCar
        }
    }
}

val diffCheker = object : DiffUtil.ItemCallback<HybridLIstItem>() {
    override fun areItemsTheSame(
        oldItem: HybridLIstItem,
        newItem: HybridLIstItem
    ): Boolean {
        return false
    }

    override fun areContentsTheSame(
        oldItem: HybridLIstItem,
        newItem: HybridLIstItem
    ): Boolean {
        return false
    }

}
