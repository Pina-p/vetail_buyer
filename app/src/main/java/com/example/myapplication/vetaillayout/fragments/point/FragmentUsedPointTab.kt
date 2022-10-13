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
import com.example.myapplication.vetaillayout.adapters.UsedPointData
import com.example.myapplication.vetaillayout.databinding.FragmentUsedPointTabBinding


class FragmentUsedPointTab : Fragment() {

    private lateinit var binding : FragmentUsedPointTabBinding
    private lateinit var usedPointAdapter: UsedPointAdapter
    private lateinit var recyclerView : RecyclerView
    var usedPointList = ArrayList<UsedPointData>()

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

        addHistoryData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView= view.findViewById(R.id.rvUsedPoint)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)
        usedPointAdapter = UsedPointAdapter(usedPointList)
        recyclerView.adapter = usedPointAdapter
    }

    fun addHistoryData(){
        usedPointList.add(
            UsedPointData(R.drawable.logo_nike,R.color.black,"1 hr ago","Aye Sein",
                "40,000","ဆုလက်ဆောင်လဲလှယ်လိုက်သည်","","Bangkokk Flight 30% off","",
                "","",false)
        )

        usedPointList.add(
            UsedPointData(R.drawable.logo_sc,R.color.black,"13 Aug 22 06:00 AM","Jit Two",
                "12,000","Wai Wai, Ahlone Branch မှ နှုတ်ယူလိုက်သည်","","","Order: 8978899",
                "50,000 Ks","အော်ဒါအတွက် ကျသင့်ငွေအစား ပွိုင့်ကို နှုတ်ယူလိုက်ပါပြီ",false)
        )

        usedPointList.add(
            UsedPointData(
                R.drawable.logo_oway,R.color.black,"1 min","Ba Din",
                "67,000","မန်ဘာပွိုင့်များဖြင့် ‌စျေးဝယ်ယူခဲ့သည်","","","Order: 8978899",
                "50,000 Ks","",false)
        )
    }

}