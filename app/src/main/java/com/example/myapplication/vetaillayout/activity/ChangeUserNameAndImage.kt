package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivityChangeUserNameAndImageBinding

class ChangeUserNameAndImage : AppCompatActivity() {
    private lateinit var binding: ActivityChangeUserNameAndImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeUserNameAndImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}