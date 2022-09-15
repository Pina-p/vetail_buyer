package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityMainBinding
import com.example.myapplication.vetaillayout.fragments.FragmentHome
import com.example.myapplication.vetaillayout.fragments.FragmentProfile
import com.example.myapplication.vetaillayout.fragments.FragmentShop

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        binding.bottomNavBar.setItemSelected(R.id.person,true)
//        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,FragmentHome()).commit()
//
//        binding.bottomNavBar.setOnItemSelectedListener{
//        var fragment : Fragment? = null
//            when(it){
//                R.id.person -> fragment= FragmentHome()
//                R.id.home -> fragment = FragmentShop()
//                R.id.settings -> fragment = FragmentProfile()
//            }
//            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment!!).commit()
//        }

    }


}