package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.vetaillayout.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClicks()
        binding.tvForgotPw.setOnClickListener {
            Intent(this,ForgotPwdActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    fun onClicks(){
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }
        binding.btnLogin.setOnClickListener{
            Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show()
        }

    }
}