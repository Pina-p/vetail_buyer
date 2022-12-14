package com.example.myapplication.vetaillayout.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ItemImageRvBinding

class ShopListItemsDetailRVAdapter(val imgList: List<Int>) :
    RecyclerView.Adapter<ShopListItemsDetailRVAdapter.ImageListHolder>() {
    inner class ImageListHolder(private val binding: ItemImageRvBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(imgList:Int){
                binding.ivImage.load(imgList)
                //binding.ivImage.setImageResource(imgList)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListHolder {
        return ImageListHolder(ItemImageRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageListHolder, position: Int) {
        holder.bind(imgList[position])
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

}