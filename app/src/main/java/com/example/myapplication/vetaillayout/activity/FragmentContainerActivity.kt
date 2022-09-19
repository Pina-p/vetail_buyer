package com.example.myapplication.vetaillayout.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.vetaillayout.databinding.ActivityFragmentContainerBinding

class FragmentContainerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentContainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var userProfile = intent.getIntExtra("userProfile",0)
        var userName = intent.getStringExtra("userName")

    }

}