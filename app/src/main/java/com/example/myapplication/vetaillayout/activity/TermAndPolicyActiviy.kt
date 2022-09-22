package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityTermAndPolicyActiviyBinding

class TermAndPolicyActiviy : AppCompatActivity() {
    private lateinit var binding:ActivityTermAndPolicyActiviyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTermAndPolicyActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor= ContextCompat.getColor(this,R.color.blueOne)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        onClicks()
    }

    private fun onClicks() {
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }

    }
}