package com.example.myapplication.vetaillayout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.FragmentAddNewAddrBinding

class FragmentAddNewAddr : Fragment() {
    private lateinit var binding : FragmentAddNewAddrBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewAddrBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cities = resources.getStringArray(R.array.cities)
        val adapter = ArrayAdapter<String>(requireActivity(),R.layout.dropdown_item,cities)
        binding.autoComplete.setAdapter(adapter)

    }
}