package com.example.myapplication.vetaillayout.adapters

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.vetaillayout.databinding.AddressItemBinding
import com.example.myapplication.vetaillayout.databinding.ShopPointItemsBinding
import com.example.myapplication.vetaillayout.model.Address
import com.example.myapplication.vetaillayout.model.ShopPoints

class ShopPointAdapter (val lists: List<ShopPoints>) :
    RecyclerView.Adapter<ShopPointAdapter.ShopPointHolder>() {
    inner class ShopPointHolder(private val binding: ShopPointItemsBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(list: ShopPoints) {
            binding.ivShopImg.load(list.shopImage)
            binding.tvPointNum.text = list.points
            binding.tvShopName.text = list.shopName

            if(adapterPosition == lists.size-1){
                binding.vView.visibility = View.GONE
            }
        }

    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopPointHolder {
            return ShopPointHolder(
                ShopPointItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }

        override fun onBindViewHolder(holder: ShopPointHolder, position: Int) {
            holder.bind(lists[position])
        }

        override fun getItemCount(): Int {
            return lists.size
        }

}