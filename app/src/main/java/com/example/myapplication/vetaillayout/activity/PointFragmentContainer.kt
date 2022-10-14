package com.example.myapplication.vetaillayout.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import coil.size.ViewSizeResolver
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityPointFragmentContainerBinding
import com.example.myapplication.vetaillayout.fragments.point.FragmentPoints

class PointFragmentContainer : AppCompatActivity() {
    private lateinit var binding : ActivityPointFragmentContainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointFragmentContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)




       // replaceFragment(FragmentPoints())
        //replaceFragment(FragmentPointHistory())

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
//    override fun onBackPressed() {
//        val count = supportFragmentManager.backStackEntryCount
//        if (count == 0) {
//            super.onBackPressed()
//            //additional code
//        } else {
//            supportFragmentManager.popBackStack()
//        }
//    }
}