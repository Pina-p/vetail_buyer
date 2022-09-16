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
import com.example.myapplication.vetaillayout.databinding.MyShopListItemBinding
import com.example.myapplication.vetaillayout.databinding.ReceivedPointHistoryItemBinding
import com.example.myapplication.vetaillayout.model.Address
import com.example.myapplication.vetaillayout.model.HomeShopPoint
import com.example.myapplication.vetaillayout.model.MyShops
import com.example.myapplication.vetaillayout.model.ReceivedPoints

class MyShopsAdapter (val list: List<MyShops>) :
    RecyclerView.Adapter<MyShopsAdapter.MyShopHolder>() {
    inner class MyShopHolder(private val binding: MyShopListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : MyShops){
            binding.ivShopImg.load(list.shopImg)
            binding.tvShopName.text = list.shopName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyShopHolder {
        return MyShopHolder(
            MyShopListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MyShopHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}