package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfileImg.load(R.drawable.naruto_profile){
            crossfade(true)
            crossfade(1000)
            transformations(CircleCropTransformation())
        }

        binding.ivForwardArrow.setOnClickListener {
            Intent(this,SecuritySettingActivity::class.java).also { startActivity(it) }
        }
    }

}