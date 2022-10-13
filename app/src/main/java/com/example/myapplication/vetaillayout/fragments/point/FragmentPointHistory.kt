package com.example.myapplication.vetaillayout.fragments.point

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.exam.homepage.fragment.FragmentExpiredTab
import com.exam.homepage.fragment.FragmentRankingTab
import com.exam.homepage.fragment.FragmentReceivedPointTab
import com.exam.homepage.fragment.FragmentUsedPointTab
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.FragmentAdapter
import com.example.myapplication.vetaillayout.databinding.PointHistoryBinding
import com.example.myapplication.vetaillayout.fragments.PointHistoryFilterFragment

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
        binding.viewPager.adapter= fragmentAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        //binding.tabLayout.setSelectedTabIndicatorColor(Color. parseColor("#ffffff"))

        binding.ivFilter.setOnClickListener {
            val pointHistoryFilterFragment = PointHistoryFilterFragment()
            pointHistoryFilterFragment.show(parentFragmentManager,pointHistoryFilterFragment.TAG)
        }

        binding.ivBackArrow.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}