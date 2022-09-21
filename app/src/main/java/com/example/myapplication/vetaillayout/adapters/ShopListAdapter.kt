package com.example.myapplication.vetaillayout.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ItemShopListBinding
import com.example.myapplication.vetaillayout.model.ShopList
import com.example.myapplication.vetaillayout.model.ShopListItems

class ShopListAdapter(val shopList: List<ShopList>) :
    RecyclerView.Adapter<ShopListAdapter.ShopListHolder>() {
    inner class ShopListHolder(private val binding: ItemShopListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shop:ShopList){
        binding.ivShopLogo.setImageResource(shop.shopIcon)
            binding.tvShopName.text=shop.shopName
            binding.tvMyPoints.text=shop.myPoints
            val shopListItemsAdapter=ShopListItemsAdapter(shop.shopItems)
            binding.rvShopItems.adapter=shopListItemsAdapter
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListHolder {
        return ShopListHolder(ItemShopListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShopListHolder, position: Int) {
        holder.bind(shopList[position])
        if (position==0){
            holder.itemView.background=ContextCompat.getDrawable(holder.itemView.context,R.color.yellowishYellow)
            holder.itemView.findViewById<TextView>(R.id.tvMyPoints).setTextColor(holder.itemView.resources.getColor(R.color.black))
            holder.itemView.findViewById<ImageView>(R.id.ivShare).setImageResource(R.drawable.ic_share_icon)
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }


}