package com.example.myapplication.vetaillayout.fragments

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.MainActivity
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
            MyShops(1,R.drawable.sweetie,"Sweetie Beauty & Spa"),
            MyShops(2,R.drawable.spicy_pot,"Mala King Hotpot & BBQ"),
            MyShops(3,R.drawable.your_deli,"SONIC  Delivery"),
            MyShops(4,R.drawable.pink_r,"Sweetie Beauty & Spa")

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