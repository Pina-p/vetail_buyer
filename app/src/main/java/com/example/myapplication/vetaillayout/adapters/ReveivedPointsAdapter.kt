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
import com.example.myapplication.vetaillayout.databinding.ReceivedPointHistoryItemBinding
import com.example.myapplication.vetaillayout.model.Address
import com.example.myapplication.vetaillayout.model.ReceivedPoints

class ReveivedPointsAdapter (val list: List<ReceivedPoints>) :
    RecyclerView.Adapter<ReveivedPointsAdapter.ReceivedPointsHolder>() {
    inner class ReceivedPointsHolder(private val binding: ReceivedPointHistoryItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : ReceivedPoints){
            binding.ivShopImg.load(list.shopImage)
            binding.tvShopName.text = list.shopName
            binding.tvNoteText.text = list.note
            binding.tvHashTag.text = list.hashTag
            binding.tvPointNum.text = list.points
            binding.tvDate.text = list.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceivedPointsHolder {
        return ReceivedPointsHolder(
            ReceivedPointHistoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ReceivedPointsHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}