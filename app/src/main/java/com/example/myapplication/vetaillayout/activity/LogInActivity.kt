package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClicks()
        binding.tvForgotPw.setOnClickListener {
            Intent(this, ForgotPwdActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    fun onClicks() {
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }
        binding.etPhNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.isNullOrEmpty()) {
                    Log.d("Ache","one")
                    binding.btnLogin.background =
                        resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                    binding.btnLogin.isClickable=false
                }
                if (!p0.isNullOrEmpty() && !binding.etPw.text.isNullOrEmpty()){
                    binding.btnLogin.background=resources.getDrawable(R.drawable.custom_button_blue)
                    binding.btnLogin.isClickable=true
                }
                else if(!p0.isNullOrEmpty()){
                    Log.d("Ache","two")
                    binding.etPw.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                        }

                        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                            if (p0.isNullOrEmpty()||binding.etPhNo.text.isNullOrEmpty()){
                                Log.d("Ache","three")
                                binding.btnLogin.background =
                                    resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                                binding.btnLogin.isClickable=false
                            }
                            else{
                                Log.d("Ache","Success")
                                binding.btnLogin.background=resources.getDrawable(R.drawable.custom_button_blue)
                                binding.btnLogin.isClickable=true
                            }
                        }

                        override fun afterTextChanged(p0: Editable?) {

                        }
                    })
                }


            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "WelllllCommeee", Toast.LENGTH_SHORT).show()
        }

    }
}