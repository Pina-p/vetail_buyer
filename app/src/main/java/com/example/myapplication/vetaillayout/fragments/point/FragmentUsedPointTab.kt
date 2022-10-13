package com.exam.homepage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.UsedPointAdapter
import com.example.myapplication.vetaillayout.model.UsedPointData
import com.example.myapplication.vetaillayout.databinding.FragmentUsedPointTabBinding
import com.example.myapplication.vetaillayout.model.usedPoint


class FragmentUsedPointTab : Fragment() {

    private lateinit var binding : FragmentUsedPointTabBinding
    private lateinit var usedPointAdapter: UsedPointAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUsedPointTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView= view.findViewById(R.id.rvUsedPoint)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)
        usedPointAdapter = UsedPointAdapter(usedPoint)
        recyclerView.adapter = usedPointAdapter
    }


}