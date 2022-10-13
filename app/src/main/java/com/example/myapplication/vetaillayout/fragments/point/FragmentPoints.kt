package com.example.myapplication.vetaillayout.fragments.point

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ShopPointAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentPointsBinding
import com.example.myapplication.vetaillayout.model.ShopPoints

class FragmentPoints : Fragment() {
    private lateinit var binding : FragmentPointsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPointsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data : ArrayList<ShopPoints> = arrayListOf(
            ShopPoints(R.drawable.logo_ruby,"Ruby Energy (Lashio)","350,000"),
            ShopPoints(R.drawable.logo_citymart,"City Mart Hledan","350,000"),
            ShopPoints(R.drawable.logo_ruby,"Ruby Energy (Lashio)","350,000"),
            ShopPoints(R.drawable.logo_ruby,"Ruby Energy (Lashio)","350,000"),
            ShopPoints(R.drawable.logo_sc,"Sweet Connect Mandalay","350,000"),
        )
        binding.rvShopPoint.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ShopPointAdapter(data)
        }
        binding.btnPointHistory.setOnClickListener {
            findNavController().navigate(R.id.action_point_history_fragment)

//            val fragmentManager = parentFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            //fragmentTransaction.addToBackStack("ni").commit()
//            fragmentTransaction.replace(R.id.fragment_container,FragmentPointHistory())
//            //fragmentTransaction.add(R.id.fragment_container,FragmentPointHistory())
//
//            fragmentTransaction.commit()
        }
    }

}