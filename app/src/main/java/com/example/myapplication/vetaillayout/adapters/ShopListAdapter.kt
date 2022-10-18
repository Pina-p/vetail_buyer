package com.example.myapplication.vetaillayout.adapters

import android.graphics.Color
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ItemShopListBinding
import com.example.myapplication.vetaillayout.model.ShopList

class ShopListAdapter(val shopList: List<ShopList>) :
    RecyclerView.Adapter<ShopListAdapter.ShopListHolder>() {
    inner class ShopListHolder(private val binding: ItemShopListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shop:ShopList){
        binding.ivShopLogo.setImageResource(shop.shopIcon)
            binding.tvShopName.text=shop.shopName
            binding.tvMyPoints.text=shop.myPoints
            binding.ivShare.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "You are sent to a website",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListHolder {
        return ShopListHolder(ItemShopListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShopListHolder, position: Int) {
        holder.bind(shopList[position])
        if (position==0){
            holder.itemView.background=ContextCompat.getDrawable(holder.itemView.context,R.color.yellowishYellow)
            holder.itemView.findViewById<TextView>(R.id.tvMyPoints).setTextColor(Color.parseColor("#5B4200"))
            holder.itemView.findViewById<TextView>(R.id.tvPts).setTextColor(Color.parseColor("#5B4200"))
            holder.itemView.findViewById<ImageView>(R.id.ivShare).setImageResource(R.drawable.ic_share_icon_yellow)
           }
        val rvShopItem=holder.itemView.findViewById<RecyclerView>(R.id.rvShopItems)
        val shopListItemsAdapter=ShopListItemsAdapter(shopList[position].shopListItems,position)
        rvShopItem.adapter=shopListItemsAdapter

        holder.itemView.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}