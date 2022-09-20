package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityTermAndPolicyActiviyBinding

class TermAndPolicyActiviy : AppCompatActivity() {
    private lateinit var binding:ActivityTermAndPolicyActiviyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTermAndPolicyActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClicks()
    }

    private fun onClicks() {
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }

    }
}