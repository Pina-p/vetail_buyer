package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.vetaillayout.adapters.FragmentAdapter
import com.example.myapplication.vetaillayout.adapters.ViewPagerAdapterSignUp
import com.example.myapplication.vetaillayout.databinding.ActivitySignUpBinding
import com.example.myapplication.vetaillayout.fragments.SignUpOneFragment
import com.example.myapplication.vetaillayout.fragments.SignUpTwoFragment

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    var pageNum=0
    lateinit var fragmentAdapter:FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        fragmentAdapter=FragmentAdapter(supportFragmentManager)
//        fragmentAdapter.addFragment(SignUpOneFragment(),"SignUp")
//        fragmentAdapter.addFragment(SignUpTwoFragment(),"SignUp")
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewPager()
    }
    fun initViewPager(){
        val viewPager= binding.vpSignUp
        viewPager.adapter=ViewPagerAdapterSignUp(0)
        viewPager.isUserInputEnabled=true
        pageNum=intent.getIntExtra("changePage",0)
        Log.d("Mingalar","$pageNum")
        if (pageNum==0){
            viewPager.adapter=ViewPagerAdapterSignUp(0)
        }
        else{
            viewPager.adapter=ViewPagerAdapterSignUp(1)
        }
    }



}