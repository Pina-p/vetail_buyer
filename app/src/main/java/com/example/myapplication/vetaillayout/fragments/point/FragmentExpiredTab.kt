package com.exam.homepage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ExpiredPointAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentExpiredTabBinding
import com.example.myapplication.vetaillayout.model.ExpiredPointData


class FragmentExpiredTab : Fragment() {

    private lateinit var binding : FragmentExpiredTabBinding
    private lateinit var expiredPointAdapter: ExpiredPointAdapter
    private lateinit var recyclerView : RecyclerView
    var expiredPointList = ArrayList<ExpiredPointData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentExpiredTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addHistoryData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView= view.findViewById(R.id.rvExpiredPoint)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)
        expiredPointAdapter = ExpiredPointAdapter(expiredPointList)
        recyclerView.adapter = expiredPointAdapter

    }

    fun addHistoryData(){
        expiredPointList.add(
            ExpiredPointData(R.drawable.logo_sc,R.color.black,"10 Aug 22 02:30 PM","Khin Thein",
                "","မန်ဘာလယ်ဗယ် သက်တမ်းကုန်ဆုံးသွားပါသည်","Silver to Gold","","",
                "","",false)
        )

        expiredPointList.add(
            ExpiredPointData(R.drawable.logo_oway,R.color.black,"2 Feb 22 08:45 AM","Aye Mi San",
                "566,787","မန်ဘာပွိုင့်များ သက်တမ်းကုန်ဆုံးသွားပါသည်","","","",
                "","",false)
        )

    }


}