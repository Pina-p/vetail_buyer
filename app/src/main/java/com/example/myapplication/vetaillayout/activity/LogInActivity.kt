package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {

    /*
    Can't change the login Button to not clickable at first HELLLPPP
    *
    * */
    var tempmail1 = "kaung@gmail.com"
    var pwOftemp1 = "12345"

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
        binding.btnLogin.isEnabled = false
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }

        binding.etPhNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.isNullOrEmpty()) {
                    binding.btnLogin.background =
                        resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                    binding.btnLogin.isEnabled = false
                }
                if (!p0.isNullOrEmpty() && !binding.etPw.text.isNullOrEmpty()) {
                    binding.btnLogin.background =
                        resources.getDrawable(R.drawable.custom_button_blue)
                    binding.btnLogin.isEnabled = true
                } else if (!p0.isNullOrEmpty()) {
                    binding.etPw.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(
                            p0: CharSequence?,
                            p1: Int,
                            p2: Int,
                            p3: Int
                        ) {
                        }
                        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                            if (p0.isNullOrEmpty() || binding.etPhNo.text.isNullOrEmpty()) {
                                binding.btnLogin.background =
                                    resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                                binding.btnLogin.isEnabled = false
                            } else {
                                binding.btnLogin.background =
                                    resources.getDrawable(R.drawable.custom_button_blue)
                                binding.btnLogin.isEnabled = true
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
            if (binding.etPhNo.text.toString() != tempmail1) {
                binding.tvEmailError.visibility = View.VISIBLE
            } else {
                binding.tvEmailError.visibility = View.GONE
                if (binding.etPw.text.toString() != pwOftemp1) {
                    binding.tvPwError.visibility = View.VISIBLE
                } else {
                    binding.tvPwError.visibility = View.GONE
                    Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                }
            }

        }

        binding.tvForgotPw.setOnClickListener {
            startActivity(Intent(this, ForgotPwdActivity::class.java))
        }

    }
}