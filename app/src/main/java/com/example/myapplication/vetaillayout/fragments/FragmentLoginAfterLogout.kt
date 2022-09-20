package com.example.myapplication.vetaillayout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.FragmentLoginAfterLogoutBinding

class FragmentLoginAfterLogout : Fragment() {
    private lateinit var binding: FragmentLoginAfterLogoutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginAfterLogoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivUserProfile.load(R.drawable.ic_small_face){
            transformations(CircleCropTransformation())
        }


    }
}