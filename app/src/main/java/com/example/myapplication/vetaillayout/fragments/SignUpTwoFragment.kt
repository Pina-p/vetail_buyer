package com.example.myapplication.vetaillayout.fragments

import android.content.Intent
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import androidx.navigation.fragment.findNavController
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.NewPwdActivity
import com.example.myapplication.vetaillayout.activity.SignUpFinishActiviy
import com.example.myapplication.vetaillayout.activity.TermAndPolicyActiviy
import com.example.myapplication.vetaillayout.databinding.FragmentSignUpOneBinding
import com.example.myapplication.vetaillayout.databinding.FragmentSignUpTwoBinding

class SignUpTwoFragment : Fragment() {
    private lateinit var binding: FragmentSignUpTwoBinding
    var tempOTP="123456"
    var count=1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpTwoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClicks()
    }

    private fun onClicks() {
        binding.otpView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (count <= 3) {
                    binding.tvOtpWrong.visibility = View.GONE
                    binding.otpView.setLineColor(ContextCompat.getColorStateList(binding.root.context,R.color.greyer))
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

        binding.btnSubmit.setOnClickListener {
            if (count < 3) {
                if (binding.otpView.text.toString() == tempOTP) {
                    startActivity(Intent(binding.root.context, SignUpFinishActiviy::class.java))
                } else {
                    binding.btnSubmit.isEnabled = false
                    binding.btnSubmit.background =
                        resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                    binding.tvOtpWrong.visibility = View.VISIBLE
                    binding.otpView.setLineColor(ContextCompat.getColorStateList(binding.root.context,R.color.red))
                    count++
                }
            } else {
                binding.btnSubmit.isEnabled = false
                binding.btnSubmit.background =
                    resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                binding.tvOtpLimit.visibility = View.VISIBLE
                binding.otpView.setLineColor(ContextCompat.getColorStateList(binding.root.context,R.color.red))
                binding.tvOtpWrong.visibility = View.VISIBLE
            }
        }
    }

}