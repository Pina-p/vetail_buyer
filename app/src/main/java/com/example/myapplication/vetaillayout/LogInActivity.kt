package com.example.myapplication.vetaillayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener{
        }
    }
}