package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.exam.homepage.fragment.FragmentExpiredTab
import com.exam.homepage.fragment.FragmentRankingTab
import com.exam.homepage.fragment.FragmentReceivedPointTab
import com.exam.homepage.fragment.FragmentUsedPointTab
import com.example.myapplication.vetaillayout.adapters.FragmentAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityPointHistoryBinding
import com.example.myapplication.vetaillayout.fragments.PointHistoryFilterFragment

class PointHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPointHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentAdapter = FragmentAdapter(supportFragmentManager)

        fragmentAdapter.addFragment(FragmentReceivedPointTab.newInstance("pointHistory"),"ရရှိသောပွိုင့်")
        fragmentAdapter.addFragment(FragmentUsedPointTab.newInstance("pointHistory"),"အသုံးပြုသောပွိုင့်")
        fragmentAdapter.addFragment(FragmentRankingTab.newInstance("pointHistory"),"အဆင့်အပြောင်းအလဲ")
        fragmentAdapter.addFragment(FragmentExpiredTab.newInstance("pointHistory"),"သက်တမ်းကုန်သွားသော")

        // fragmentAdapter.addFragment(Fragment7(),"??")
        binding.viewPager.adapter= fragmentAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        //binding.tabLayout.setSelectedTabIndicatorColor(Color. parseColor("#ffffff"))

        binding.ivFilter.setOnClickListener {
            val pointHistoryFilterFragment = PointHistoryFilterFragment()
            pointHistoryFilterFragment.show(supportFragmentManager,pointHistoryFilterFragment.TAG)
        }

        binding.ivBackArrow.setOnClickListener {
            onBackPressed()
        }
    }
}