package com.example.myapplication.vetaillayout.fragments.point

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.vetaillayout.databinding.FragmentRankingTabBinding
import com.example.myapplication.vetaillayout.databinding.FragmentReceivedPointTabBinding

class FragmentRankingTab : Fragment() {
    private lateinit var binding : FragmentRankingTabBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRankingTabBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}