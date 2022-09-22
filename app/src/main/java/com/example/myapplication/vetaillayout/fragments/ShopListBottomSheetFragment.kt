package com.example.myapplication.vetaillayout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ShopListItemsDetailRVAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentShopListBottomSheetBinding
import com.example.myapplication.vetaillayout.model.ShopListItems
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShopListBottomSheetFragment(val shopListItem: ShopListItems) : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentShopListBottomSheetBinding

    override fun getTheme(): Int {
//        Toast.makeText(binding.root.context, "called", Toast.LENGTH_SHORT).show()

        return R.style.NoBackGroundDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShopListBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivFullImage.setImageResource(shopListItem.itemImage[0])
        binding.tvItemName.text=shopListItem.itemName
        if (shopListItem.hot){
            binding.ivHotIcon.visibility=View.VISIBLE
        }
        else{
            binding.ivHotIcon.visibility=View.INVISIBLE
        }
        binding.tvEndTime.text=shopListItem.dateUntil
        binding.tvItemPts.text=shopListItem.itemPoint
        binding.tvAboutItem.text=shopListItem.aboutItem

        var adapter = ShopListItemsDetailRVAdapter(shopListItem.itemImage)
        binding.rvImages.adapter
    }
}