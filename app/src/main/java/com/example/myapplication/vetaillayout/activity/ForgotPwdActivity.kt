package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityForgotPwdBinding

class ForgotPwdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPwdBinding
    var tempPhNo="12345"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetOTPCode.isEnabled = false
        textChangeListener()
        onClick()

    }

    fun onClick() {

        binding.btnGetOTPCode.setOnClickListener {
            if(binding.etPhNo.text.toString()==tempPhNo){
                binding.tvError.visibility= View.GONE
                Intent(this, GetOTPActivity::class.java).also {
                    startActivity(it)
                }
            }
            else{
                binding.tvError.visibility= View.VISIBLE
                binding.tilPhNo.boxStrokeColor=resources.getColor(R.color.red)
            }

        }

        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }

    }

    fun textChangeListener() {
        binding.etPhNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    if (p0.isNullOrEmpty()) {
                        binding.btnGetOTPCode.background =
                            resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                        binding.btnGetOTPCode.isEnabled = false
                    }
                else if (p0!=null){
                    if (!p0.startsWith("09") || p0.length>=11 || p0.length<=9){
                        resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                        binding.btnGetOTPCode.isEnabled = false
                        binding.tvError.visibility= View.VISIBLE
                        binding.tilPhNo.boxStrokeColor=resources.getColor(R.color.red)

                    }
                    else{
                        binding.btnGetOTPCode.background =
                            resources.getDrawable(R.drawable.custom_button_blue)
                        binding.btnGetOTPCode.isEnabled = true
                    }

                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}