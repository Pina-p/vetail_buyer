package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityChangeUserNameAndImageBinding

class ChangeUserNameAndImage : AppCompatActivity() {
    private lateinit var binding: ActivityChangeUserNameAndImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeUserNameAndImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfileImg.load(R.drawable.naruto_profile){
            crossfade(true)
            crossfade(1000)
            transformations(CircleCropTransformation())
        }


    }
}