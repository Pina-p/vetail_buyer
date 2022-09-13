package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivityChangePhoneNumBinding
import com.example.myapplication.vetaillayout.databinding.ActivityChangePwdBinding

class ChangePhoneNum : AppCompatActivity() {
    private lateinit var binding : ActivityChangePhoneNumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePhoneNumBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}