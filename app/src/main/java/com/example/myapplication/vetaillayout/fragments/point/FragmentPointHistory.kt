package com.example.myapplication.vetaillayout.fragments.point

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.vetaillayout.adapters.FragmentAdapter
import com.example.myapplication.vetaillayout.databinding.PointHistoryBinding

class FragmentPointHistory : Fragment() {
    private lateinit var binding: PointHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PointHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAdapter = FragmentAdapter(parentFragmentManager)

        fragmentAdapter.addFragment(FragmentReceivedPointTab(),"ရရှိသောပွိုင့်")
        fragmentAdapter.addFragment(FragmentUsedPointTab(),"အသုံးပြုသောပွိုင့်")
        fragmentAdapter.addFragment(FragmentRankingTab(),"အဆင့်အပြောင်းအလဲ")
        fragmentAdapter.addFragment(FragmentExpiredTab(),"သက်တမ်းကုန်သွားသော")

        // fragmentAdapter.addFragment(Fragment7(),"??")
        binding.viewPager.adapter=fragmentAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        //binding.tabLayout.setSelectedTabIndicatorColor(Color. parseColor("#ffffff"))
    }
}