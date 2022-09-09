package com.example.myapplication.vetaillayout

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.myapplication.vetaillayout.adapters.ViewPagerAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityLogOrSignBinding
import com.google.android.material.tabs.TabLayout

class LogOrSignActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogOrSignBinding
    lateinit var tabLayout: TabLayout
    lateinit var mSLideViewPager: ViewPager
    lateinit var mDotLayout: LinearLayout


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogOrSignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LanguageSwitchTab()
        initViewPager()
        activityChange()
    }
    fun activityChange(){
        binding.btnSignUp.setOnClickListener{
            Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
        }
        binding.btnLogin.setOnClickListener{
            Intent(this,LogInActivity::class.java).also { startActivity(it) }
        }
    }

    fun LanguageSwitchTab() {
        tabLayout = findViewById(R.id.tabLayout)

        tabLayout.addTab(tabLayout.newTab().setText("MM"))
        tabLayout.addTab(tabLayout.newTab().setText("EN"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(
                    this@LogOrSignActivity,
                    "${tabLayout.selectedTabPosition}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initViewPager(){
        mSLideViewPager = binding.vpWelcome
        mDotLayout = binding.indicatorLayout
        val viewPagerAdapter = ViewPagerAdapter(this)
        mSLideViewPager.adapter = viewPagerAdapter
        setUpindicator(0)
        mSLideViewPager.addOnPageChangeListener(viewListener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setUpindicator(position: Int) {
        var dots = arrayOfNulls<TextView>(3)
        Log.d("Testing", "${dots.size}")
        mDotLayout.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this@LogOrSignActivity)
            dots[i]?.text = Html.fromHtml("&#8226")
            dots[i]?.textSize = 35f
            dots[i]?.setTextColor(resources.getColor(R.color.blueTwoLight, applicationContext.theme))
            mDotLayout.addView(dots[i])
        }
        dots[position]
            ?.setTextColor(resources.getColor(R.color.white, applicationContext.theme))
    }

    private var viewListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }
        @RequiresApi(Build.VERSION_CODES.M)
        override fun onPageSelected(position: Int) {
            setUpindicator(position)
        }
        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun getitem(i: Int): Int {
        return mSLideViewPager.getCurrentItem() + i
    }
}