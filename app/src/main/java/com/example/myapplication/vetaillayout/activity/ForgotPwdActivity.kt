package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivityForgotPwdBinding

class ForgotPwdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityForgotPwdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGetOTPCode.setOnClickListener {
            Intent(this,GetOTPActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}