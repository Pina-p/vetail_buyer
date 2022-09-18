package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.vetaillayout.adapters.ViewPagerAdapterSignUp
import com.example.myapplication.vetaillayout.adapters.ViewPagerAdapterSignUpTemp
import com.example.myapplication.vetaillayout.databinding.ActivitySignUpBinding
import com.example.myapplication.vetaillayout.fragments.SignUpOneFragment
import com.example.myapplication.vetaillayout.fragments.SignUpTwoFragment

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewPager()
    }
    fun initViewPager():ViewPager2{
        var viewPager= binding.vpSignUp
        viewPager.isUserInputEnabled=true
        val fragmentsList:ArrayList<Fragment> = arrayListOf(
            SignUpOneFragment(),
            SignUpTwoFragment()
        )
        val adapter=ViewPagerAdapterSignUpTemp(fragmentsList,this)
        viewPager.adapter=adapter
        return viewPager
    }


}