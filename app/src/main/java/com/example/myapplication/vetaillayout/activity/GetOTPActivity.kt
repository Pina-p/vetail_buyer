package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivityForgotPwdBinding
import com.example.myapplication.vetaillayout.databinding.ActivityGetOtpactivityBinding

class GetOTPActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetOtpactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}