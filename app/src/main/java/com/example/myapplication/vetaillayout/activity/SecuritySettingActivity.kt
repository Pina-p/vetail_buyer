package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.vetaillayout.databinding.ActivitySecuritySettingBinding

class SecuritySettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecuritySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecuritySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrowDeleteAcc.setOnClickListener {
            Intent(this,DeleteAccActivity::class.java).also { startActivity(it) }
        }

        binding.ivArrowChangePwd.setOnClickListener {
            Intent(this,ChangePwdActivity::class.java).also { startActivity(it) }
        }

        binding.ivBackButton.setOnClickListener {
            finish()
        }
    }
}