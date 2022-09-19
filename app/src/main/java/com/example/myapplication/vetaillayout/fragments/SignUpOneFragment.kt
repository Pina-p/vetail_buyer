package com.example.myapplication.vetaillayout.fragments

import android.content.Intent
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView.BufferType
import androidx.core.text.set
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.TermAndPolicyActiviy
import com.example.myapplication.vetaillayout.databinding.FragmentSignUpOneBinding


class SignUpOneFragment : Fragment() {
    private lateinit var binding: FragmentSignUpOneBinding
    val tempPhoneUserNum = "12345"
    val tempPhoneSellerNum = "67890"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpOneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SpannableSetUp()
        onClicks()
    }


    fun onClicks() {

        binding.etPhNo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.ivCorrect.visibility = View.INVISIBLE
                binding.btnSignUp.text = getString(R.string.signUp)
                if (p0.isNullOrEmpty()) {
                    binding.btnSignUp.background =
                        resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                } else {
                    binding.btnSignUp.background =
                        resources.getDrawable(R.drawable.custom_button_blue)
                    binding.btnSignUp.setOnClickListener {
                        if (binding.etPhNo.text.toString() == tempPhoneUserNum) {
                            binding.tvAccDuplicate.visibility = View.VISIBLE
                            binding.tilPhNo.boxStrokeColor = resources.getColor(R.color.red)
                            binding.tvAccDuplicate.text = getString(R.string.acc_exist_normal)

                        } else if (binding.etPhNo.text.toString() == tempPhoneSellerNum) {
                            binding.tvAccDuplicate.visibility = View.VISIBLE
                            binding.tilPhNo.boxStrokeColor = resources.getColor(R.color.red)
                            binding.tvAccDuplicate.text = getString(R.string.acc_exist_shopdoora)
                        } else {
                            binding.tilPhNo.boxStrokeColor = resources.getColor(R.color.blueOne)
                            binding.ivCorrect.visibility = View.VISIBLE
                            binding.tvAccDuplicate.visibility = View.GONE
                            if (binding.btnSignUp.text != getString(R.string.proceed)) {
                                binding.btnSignUp.text = getString(R.string.proceed)
                            } else if (binding.btnSignUp.text == getString(R.string.proceed)) {
                                findNavController().navigate(R.id.action_signUpOneFragment_to_signUpTwoFragment)
                            }

                        }
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })


    }

    fun SpannableSetUp(){
        val spannableString = SpannableString(getString(R.string.signin_term_and_policy))
        var i1 = spannableString.indexOf("Terms");
        var i2 = spannableString.indexOf("Services")
        var i3 = spannableString.indexOf("Privacy")
        var i4 = spannableString.indexOf("policy")

        binding.tvTermAndPolicy.movementMethod = LinkMovementMethod.getInstance()
        binding.tvTermAndPolicy.setText(spannableString, BufferType.SPANNABLE)
        val SpannableOne = binding.tvTermAndPolicy.text.toSpannable()
        val myClickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                ds.color = resources.getColor(R.color.blueOne)
                ds.isUnderlineText=false
            }
            override fun onClick(widget: View) {
                Intent(
                    this@SignUpOneFragment.context,
                    TermAndPolicyActiviy::class.java
                ).also { startActivity(it) }
            }
        }
        val myClickableSpan1: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                ds.color = resources.getColor(R.color.blueOne)
                ds.isUnderlineText=false
            }
            override fun onClick(widget: View) {
                Intent(
                    this@SignUpOneFragment.context,
                    TermAndPolicyActiviy::class.java
                ).also { startActivity(it) }
            }
        }

        SpannableOne
            .setSpan(myClickableSpan, i1, i2 + 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        SpannableOne
            .setSpan(myClickableSpan1, i3, i4 + 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.tvTermAndPolicy.setText(SpannableOne)
    }
}