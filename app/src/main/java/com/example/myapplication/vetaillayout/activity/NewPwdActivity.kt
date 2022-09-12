package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.vetaillayout.databinding.ActivityNewPwdBinding

class NewPwdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewPwdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}