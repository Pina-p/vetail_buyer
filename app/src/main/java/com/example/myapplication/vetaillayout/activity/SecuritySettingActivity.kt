package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivitySecuritySettingBinding

class SecuritySettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecuritySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecuritySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}