package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityNewPwdBinding

class NewPwdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewPwdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
    }

    fun onClick() {
        textListener()
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }

        binding.btnSignUp.setOnClickListener {
            if (binding.etNewPwd.text.toString() != binding.etNewPwd.text.toString()) {
                binding.tvPwdNotMatch.visibility = View.VISIBLE
                binding.btnSignUp.background =
                    resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                binding.btnSignUp.isEnabled=false

                binding.tilNewPwd.boxStrokeColor=resources.getColor(R.color.red)
                binding.tilPwConfirm.boxStrokeColor=resources.getColor(R.color.red)
            }

            else{
                startActivity(Intent(this,LogInActivity::class.java))
            }
        }

    }

    private fun textListener() {
        binding.etNewPwd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!p0.isNullOrEmpty()) {
                    binding.btnSignUp.background =
                        resources.getDrawable(R.drawable.custom_button_blue)
                    binding.btnSignUp.isEnabled=true
                    binding.tilNewPwd.boxStrokeColor=resources.getColor(R.color.greyer)
                    binding.tilPwConfirm.boxStrokeColor=resources.getColor(R.color.greyer)
                }
                else{
                    binding.btnSignUp.background =
                        resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                    binding.btnSignUp.isEnabled=false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}