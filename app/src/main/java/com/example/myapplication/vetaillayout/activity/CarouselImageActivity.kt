package com.example.myapplication.vetaillayout.activity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.CarouselAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityCarouselImageBinding
import kotlin.math.abs


class CarouselImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarouselImageBinding
    private lateinit var viewPager:ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarouselImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window: Window = window
            val decorView: View = window.decorView
            val wic = WindowInsetsControllerCompat(window, decorView)
            wic.isAppearanceLightStatusBars = false // true or false as desired.

            // And then you can set any background color to the status bar.
            window.statusBarColor = resources.getColor(R.color.blackisher_black)
        }
        binding.ivBackButton.setOnClickListener {
            finish()
        }
        viewPagerInit()
    }

    fun viewPagerInit() {
        viewPager=binding.vpCarousel
        val imgList = intent.getIntegerArrayListExtra("carousel")
        var carouselAdapter = CarouselAdapter(this@CarouselImageActivity, imgList!!.toList())
        viewPager.adapter = carouselAdapter

        viewPager.setPageTransformer(false
        ) { page, _ ->
            val pageWidth: Int =
                viewPager.measuredWidth - viewPager.paddingLeft - viewPager.paddingRight
            val pageHeight: Int = viewPager.height
            val paddingLeft: Int = viewPager.paddingLeft
            val transformPos =
                (page.left - (viewPager.scrollX + paddingLeft)).toFloat() / pageWidth
            val normalizedposition = abs(abs(transformPos) - 1)
            page.alpha = normalizedposition + 0.5f
            val max = -pageHeight / 10
            if (transformPos < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.translationY = 0f
            } else if (transformPos <= 1) { // [-1,1]
                page.translationY = max * (1 - abs(transformPos))
            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.translationY = 0f
            }
        }
    }
}