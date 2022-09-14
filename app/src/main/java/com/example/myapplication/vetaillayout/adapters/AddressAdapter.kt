package com.example.myapplication.vetaillayout.adapters

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.databinding.AddressItemBinding
import com.example.myapplication.vetaillayout.model.Address

class AddressAdapter (val list: List<Address>) :
    RecyclerView.Adapter<AddressAdapter.AddressHolder>() {

    inner class AddressHolder(private val binding: AddressItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : Address){
            binding.tvPlace.text = list.category
            binding.tvAddress.text = list.address
            binding.tvNearPlace.text = list.near
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressHolder {
        return AddressHolder(
            AddressItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: AddressHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}