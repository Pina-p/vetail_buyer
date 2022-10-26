package com.example.myapplication.vetaillayout.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.text.Layout
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.*
import com.example.myapplication.vetaillayout.model.Address
import com.example.myapplication.vetaillayout.model.HomeShopPoint
import com.example.myapplication.vetaillayout.model.MyShops
import com.example.myapplication.vetaillayout.model.ReceivedPoints

class ProfileMyShopsAdapter (val list: List<MyShops>) :
    RecyclerView.Adapter<ProfileMyShopsAdapter.ProfileMyShopHolder>() {


    inner class ProfileMyShopHolder(private val binding: ProfileMyShopsBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : MyShops){
            binding.ivShopImg.load(list.shopImg)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileMyShopHolder {
        return ProfileMyShopHolder(
            ProfileMyShopsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ProfileMyShopHolder, position: Int) {
        holder.bind(list[position])
    }
    override fun getItemCount(): Int {
        return list.size
    }

}