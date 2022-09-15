package com.example.myapplication.vetaillayout.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.FragmentHomeBinding
import com.example.myapplication.vetaillayout.databinding.FragmentShopBinding

class FragmentShop : Fragment() {
    private lateinit var binding : FragmentShopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShopBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Mingalar","onviewCreated")
    }
}