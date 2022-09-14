package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivityConnectWithEmailBinding

class ConnectWithEmail : AppCompatActivity() {
    private lateinit var binding : ActivityConnectWithEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConnectWithEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}