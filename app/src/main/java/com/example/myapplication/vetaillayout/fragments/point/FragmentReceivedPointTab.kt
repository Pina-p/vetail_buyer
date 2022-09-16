package com.example.myapplication.vetaillayout.fragments.point

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ReveivedPointsAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentReceivedPointTabBinding
import com.example.myapplication.vetaillayout.databinding.FragmentReceivedPointsBinding
import com.example.myapplication.vetaillayout.databinding.PointHistoryBinding
import com.example.myapplication.vetaillayout.model.ReceivedPoints

class FragmentReceivedPointTab : Fragment() {
    private lateinit var binding: FragmentReceivedPointTabBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceivedPointTabBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val data : ArrayList<ReceivedPoints> = arrayListOf(
            ReceivedPoints(R.drawable.shop_img1,"Ruby Energy (Lashio)","#090909","လက်ဆောင် ပွိုင့်လေးပါခင်ဗျာ","+1,000","1 Sep 22 04:00 PM"),
            ReceivedPoints(R.drawable.shop_img1,"Ruby Energy (Lashio)","#GivingCoin","လက်ဆောင် ပွိုင့်လေးပါခင်ဗျာ","+600","28 Aug 22 09:00 PM"),
            ReceivedPoints(R.drawable.shop_img1,"Ruby Energy (Lashio)","#GivingCoin","လက်ဆောင် ပွိုင့်လေးပါခင်ဗျာ","+10","25 Aug 22 01:23 PM"),
            ReceivedPoints(R.drawable.shop_img1,"Ruby Energy (Lashio)","#GivingCoin","လက်ဆောင် ပွိုင့်လေးပါခင်ဗျာ","+6","13 Aug 22 07:00 AM"),
        )
        binding.rvReceivedPointHistory.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = ReveivedPointsAdapter(data)
        }
    }
}