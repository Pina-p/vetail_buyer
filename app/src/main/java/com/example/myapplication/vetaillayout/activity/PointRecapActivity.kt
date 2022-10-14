package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityPointHistoryBinding
import com.example.myapplication.vetaillayout.databinding.ActivityPointRecapBinding

class PointRecapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPointRecapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointRecapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivCloseButton.setOnClickListener {
            onBackPressed()
        }
    }
}