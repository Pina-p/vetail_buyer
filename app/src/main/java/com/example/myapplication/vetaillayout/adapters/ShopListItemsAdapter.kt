package com.example.myapplication.vetaillayout.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.databinding.ItemShopItemBinding
import com.example.myapplication.vetaillayout.model.ShopListItems

class ShopListItemsAdapter(val shopListItems: List<ShopListItems>)
    :RecyclerView.Adapter<ShopListItemsAdapter.ShopListItemsHolder>(){
        inner class ShopListItemsHolder(private val binding: ItemShopItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(itemList:ShopListItems){
                binding.ivItemImage.setImageResource(itemList.itemImage)
                binding.tvItemName.text=itemList.itemName
                binding.tvItemPts.text=itemList.itemPoint
                if (itemList.hot==true){
                    binding.ivHotIcon.visibility=View.VISIBLE
                }
                else{
                    binding.ivHotIcon.visibility=View.GONE
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListItemsHolder {
        return ShopListItemsHolder(ItemShopItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ShopListItemsHolder, position: Int) {
        holder.bind(shopListItems[position])
    }

    override fun getItemCount(): Int {
        return shopListItems.size
    }

}