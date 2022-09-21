package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
        //initViewPager()
    }
    fun onClick(){
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }
    }
//    fun initViewPager():ViewPager2{
//        var viewPager= binding.vpSignUp
//        viewPager.isUserInputEnabled=true
//        val fragmentsList:ArrayList<Fragment> = arrayListOf(
//            SignUpOneFragment(),
//            SignUpTwoFragment()
//        )
//        val adapter=ViewPagerAdapterSignUpTemp(fragmentsList,this)
//        viewPager.adapter=adapter
//        return viewPager
//    }


}