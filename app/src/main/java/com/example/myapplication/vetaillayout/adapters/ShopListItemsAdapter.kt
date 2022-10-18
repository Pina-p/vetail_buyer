package com.example.myapplication.vetaillayout.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ItemShopItemBinding
import com.example.myapplication.vetaillayout.fragments.ShopListBottomSheetFragment
import com.example.myapplication.vetaillayout.model.ShopListItems

class ShopListItemsAdapter(val shopListItems: List<ShopListItems>, var positionRv: Int)
    :RecyclerView.Adapter<ShopListItemsAdapter.ShopListItemsHolder>(){
    inner class ShopListItemsHolder(private val binding: ItemShopItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(itemList:ShopListItems){
                if (positionRv==0){
                    binding.btnCheck.setBackgroundResource(R.drawable.custom_mini_button_red)
                    binding.cvCard.setCardBackgroundColor(Color.WHITE)
                }

                binding.ivItemImage.setImageResource(itemList.itemImage[0])
                binding.tvItemName.text=itemList.itemName
                binding.tvItemPts.text=itemList.itemPoint

                if (itemList.hot){
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
        var btn =holder.itemView.findViewById<Button>(R.id.btnCheck)
        btn.setOnClickListener {
            showDialog(holder,shopListItems[position])
        }
        holder.itemView.setOnClickListener {
        showDialog(holder,shopListItems[position])
        }
    }

    override fun getItemCount(): Int {
        return shopListItems.size
    }

    private fun showDialog(holder: ShopListItemsHolder, shopListItems: ShopListItems) {
        var manager: FragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
        ShopListBottomSheetFragment(shopListItems).show(manager,"this")
//        val dialog= Dialog(holder.itemView.context)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setContentView(R.layout.fragment_shop_list_bottom_sheet)
//        dialog.show()
//        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
//        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog.window?.attributes?.windowAnimations=R.style.DialogAnimation
//        dialog.window?.setGravity(Gravity.BOTTOM)
    }

}