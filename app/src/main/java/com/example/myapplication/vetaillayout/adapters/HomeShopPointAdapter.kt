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
import coil.load
import com.example.myapplication.vetaillayout.databinding.AddressItemBinding
import com.example.myapplication.vetaillayout.databinding.HomeShopPointItemBinding
import com.example.myapplication.vetaillayout.databinding.ReceivedPointHistoryItemBinding
import com.example.myapplication.vetaillayout.model.Address
import com.example.myapplication.vetaillayout.model.HomeShopPoint
import com.example.myapplication.vetaillayout.model.ReceivedPoints

class HomeShopPointAdapter (val list: List<HomeShopPoint>) :
    RecyclerView.Adapter<HomeShopPointAdapter.HomeShopPointHolder>() {
    inner class HomeShopPointHolder(private val binding: HomeShopPointItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : HomeShopPoint){
            binding.ivBg.load(list.shopBgImg)
            binding.tvShopName.text = list.shopName
            binding.tvEarnPoint.text = "earn "+list.point.toString()+" point"
            binding.tvKyat.text = "Ks"+list.amount

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeShopPointHolder {
        return HomeShopPointHolder(
            HomeShopPointItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: HomeShopPointHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}