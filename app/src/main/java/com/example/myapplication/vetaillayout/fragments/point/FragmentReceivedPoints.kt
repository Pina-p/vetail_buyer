package com.example.myapplication.vetaillayout.fragments.point

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ShopPointAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentReceivedPointsBinding
import com.example.myapplication.vetaillayout.model.ShopPoints

class FragmentReceivedPoints : Fragment() {
    private lateinit var binding: FragmentReceivedPointsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceivedPointsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data : ArrayList<ShopPoints> = arrayListOf(
            ShopPoints(R.drawable.shop_img1,"RUBY Energy (Lashio)","350,000"),
            ShopPoints(R.drawable.shop_img2,"City Mart Hledan","350,000"),
            ShopPoints(R.drawable.shop_img1,"YGN GYM","350,000"),
            ShopPoints(R.drawable.shop_img2,"Mc Donald's","350,000"),
            ShopPoints(R.drawable.shop_img1,"Apple Store","350,000"),
            ShopPoints(R.drawable.shop_img2,"Air Asia","350,000"),
            ShopPoints(R.drawable.shop_img1,"Sweet Connect Mandalay","350,000")
        )
        binding.rvShopPoint.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = ShopPointAdapter(data)
        }
    }
}