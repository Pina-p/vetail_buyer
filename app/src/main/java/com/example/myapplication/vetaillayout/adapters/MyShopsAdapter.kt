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

            binding.cvImgCard.setOnClickListener {
//                var builder = AlertDialog.Builder(itemView.context)
//                var dialogView = LayoutInflater.from(itemView.context).inflate(R.layout.home_custom_alertdialog_layout,null)
//                builder.setView(dialogView)
//                builder.show()

                var dialogBinding = LayoutInflater.from(itemView.context).inflate(R.layout.home_custom_alertdialog_layout,null)
                val myDialog = Dialog(itemView.context)
                var img = dialogBinding.findViewById<ImageView>(R.id.ivShopImg)
                var text = dialogBinding.findViewById<TextView>(R.id.tvLoginAcc)
                img.load(list.shopImg){
                    transformations(CircleCropTransformation())
                }
                text.text = list.shopName+"\nကိုအကောင့်ဝင်ရောက်မည်"
                myDialog.setContentView(dialogBinding)
                myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()
            }
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

    interface OnItemClickListener{
        fun onClicked()
    }
}