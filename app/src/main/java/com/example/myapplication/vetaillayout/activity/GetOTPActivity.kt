package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityForgotPwdBinding
import com.example.myapplication.vetaillayout.databinding.ActivityGetOtpactivityBinding

class GetOTPActivity : AppCompatActivity() {
    var tempOTP = "123456"
    var count = 1
    private lateinit var binding: ActivityGetOtpactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClicks()
    }

    private fun onClicks() {
        binding.otpView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (count <= 3) {
                    binding.tvOtpWrong.visibility = View.GONE
                    binding.otpView.setLineColor(ContextCompat.getColorStateList(this@GetOTPActivity,R.color.greyer))
                    if (p0?.length == 6) {
                        binding.btnSubmit.isEnabled = true
                        binding.btnSubmit.background =
                            resources.getDrawable(R.drawable.custom_button_blue)
                    } else {
                        binding.btnSubmit.isEnabled = false
                        binding.btnSubmit.background =
                            resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

         binding.ivBackButton.setOnClickListener {
             onBackPressed()
         }

        binding.btnSubmit.setOnClickListener {
            if (count < 3) {
                if (binding.otpView.text.toString() == tempOTP) {
                    startActivity(Intent(this,NewPwdActivity::class.java))
                } else {
                    binding.btnSubmit.isEnabled = false
                    binding.btnSubmit.background =
                        resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                    binding.tvOtpWrong.visibility = View.VISIBLE
                    binding.otpView.setLineColor(ContextCompat.getColorStateList(this,R.color.red))
                    count++
                }
            } else {
                binding.btnSubmit.isEnabled = false
                binding.btnSubmit.background =
                    resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                binding.tvOtpLimit.visibility = View.VISIBLE
                binding.otpView.setLineColor(ContextCompat.getColorStateList(this,R.color.red))
                binding.tvOtpWrong.visibility = View.VISIBLE
            }
        }
    }
}