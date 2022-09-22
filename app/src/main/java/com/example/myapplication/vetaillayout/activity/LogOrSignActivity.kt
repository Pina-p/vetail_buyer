package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.core.view.size
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ViewPagerAdapterLogOrSign
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

        //window.statusBarColor= ContextCompat.getColor(this,R.color.blueOne)
        //window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        spannableSetUp()
        LanguageSwitchTab()
        initViewPager()
        activityChange()

    }
    fun activityChange(){
        binding.btnSignUp.setOnClickListener{
            Intent(this, SignUpActivity::class.java).also { startActivity(it) }
        }
        binding.btnLogin.setOnClickListener{
            Intent(this, LogInActivity::class.java).also { startActivity(it) }
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
        val viewPagerAdapter = ViewPagerAdapterLogOrSign(this)
        mSLideViewPager.adapter = viewPagerAdapter
        mSLideViewPager.addOnPageChangeListener(viewListener)
        setUpindicator(0)
        val mainHandler = Handler(Looper.getMainLooper())
        var i=-1
        mainHandler.post(object :Runnable{
            override fun run() {
                if (i>=mDotLayout.size-1){
                    i=0
                    Log.d("Tutu","One")
                }
                else{
                    i++
                    Log.d("Tutu","two")
                }
                mSLideViewPager.currentItem=i
                mainHandler.postDelayed(this,3000)
            }
        })

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

    fun spannableSetUp(){
        val spannableString = SpannableString(getString(R.string.term_policy))
        var i1 = spannableString.indexOf("Terms");
        var i2 = spannableString.indexOf("Use")
        var i3 = spannableString.indexOf("Privacy")
        var i4 = spannableString.indexOf("Policy")

        binding.tvTermAndPolicy.movementMethod = LinkMovementMethod.getInstance()
        binding.tvTermAndPolicy.setText(spannableString, TextView.BufferType.SPANNABLE)
        val SpannableOne = binding.tvTermAndPolicy.text.toSpannable()
        val myClickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                ds.color = resources.getColor(R.color.blueOne)
                ds.isUnderlineText=false
            }

            override fun onClick(widget: View) {
                Intent(
                    this@LogOrSignActivity,
                    TermAndPolicyActiviy::class.java
                ).also { startActivity(it) }
            }
        }
        val myClickableSpan1: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                ds.color = resources.getColor(R.color.blueOne)
                ds.isUnderlineText=false
            }

            override fun onClick(widget: View) {
                Intent(
                    this@LogOrSignActivity,
                    TermAndPolicyActiviy::class.java
                ).also { startActivity(it) }
            }
        }

        SpannableOne
            .setSpan(myClickableSpan, i1, i2 + 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        SpannableOne
            .setSpan(myClickableSpan1, i3, i4 + 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.tvTermAndPolicy.text = SpannableOne
    }
}