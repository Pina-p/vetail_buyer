package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exam.homepage.fragment.FragmentExpiredTab
import com.exam.homepage.fragment.FragmentRankingTab
import com.exam.homepage.fragment.FragmentReceivedPointTab
import com.exam.homepage.fragment.FragmentUsedPointTab
import com.example.myapplication.vetaillayout.adapters.FragmentAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityShopDetailPointHistoryBinding

class ShopDetailPointHistory : AppCompatActivity() {
    private lateinit var binding : ActivityShopDetailPointHistoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopDetailPointHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)

        fragmentAdapter.addFragment(FragmentReceivedPointTab.newInstance("shopDetailPoint"),"ရရှိသောပွိုင့်")
        fragmentAdapter.addFragment(FragmentUsedPointTab.newInstance("shopDetailPoint"),"အသုံးပြုသောပွိုင့်")
        fragmentAdapter.addFragment(FragmentRankingTab.newInstance("shopDetailPoint"),"အဆင့်အပြောင်းအလဲ")
        fragmentAdapter.addFragment(FragmentExpiredTab.newInstance("shopDetailPoint"),"သက်တမ်းကုန်သွားသော")

        // fragmentAdapter.addFragment(Fragment7(),"??")
        binding.viewPager.adapter= fragmentAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.ibForwardArrow.setOnClickListener{
            var intent = Intent(this,PointRecapActivity::class.java)
            startActivity(intent)
        }

        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }

    }
}