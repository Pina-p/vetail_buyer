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
import androidx.core.text.toSpannable
import androidx.navigation.fragment.findNavController
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.SignUpFinishActiviy
import com.example.myapplication.vetaillayout.activity.TermAndPolicyActiviy
import com.example.myapplication.vetaillayout.databinding.FragmentSignUpOneBinding
import com.example.myapplication.vetaillayout.databinding.FragmentSignUpTwoBinding

class SignUpTwoFragment : Fragment() {
    private lateinit var binding: FragmentSignUpTwoBinding
    val tempPhoneUserNum = "12345"
    val tempPhoneSellerNum = "67890"
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

    fun onClicks() {
    binding.btnSignUp.setOnClickListener {
        startActivity(Intent(this.context,SignUpFinishActiviy::class.java))
    }
    }
}