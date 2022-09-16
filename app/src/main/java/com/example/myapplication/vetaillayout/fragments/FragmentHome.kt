package com.example.myapplication.vetaillayout.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.HomeShopPointAdapter
import com.example.myapplication.vetaillayout.adapters.MyShopsAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentHomeBinding
import com.example.myapplication.vetaillayout.databinding.FragmentSignUpOneBinding
import com.example.myapplication.vetaillayout.model.HomeShopPoint
import com.example.myapplication.vetaillayout.model.MyShops

class FragmentHome : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data : ArrayList<HomeShopPoint> = arrayListOf(
            HomeShopPoint(R.drawable.shop_ruby,"1,000",1,"RUBY Energy\n(Lashio)"),
            HomeShopPoint(R.drawable.kka,"500",1,"KKA Gold"),
            HomeShopPoint(R.drawable.future_mall,"200",1,"Future Mall\nMyanmar")
        )

        val shops: ArrayList<MyShops> = arrayListOf(
            MyShops(R.drawable.sweetie,"Sweetie\nBeauty & Spa"),
            MyShops(R.drawable.spicy_pot,"Mala King\nHotpot & BBQ"),
            MyShops(R.drawable.your_deli,"SONIC\n Delivery"),
            MyShops(R.drawable.pink_r,"Sweetie\nBeauty & Spa")

        )

        binding.rvHomeShopPoint.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(view.context,3)
            adapter = HomeShopPointAdapter(data)
        }

        binding.rvMyShops.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            adapter = MyShopsAdapter(shops)
        }
    }
}