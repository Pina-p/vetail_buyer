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
import com.example.myapplication.vetaillayout.adapters.RankChangedAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentExpiredTabBinding
import com.example.myapplication.vetaillayout.model.ExpiredPointData
import com.example.myapplication.vetaillayout.model.expiredPoint


class FragmentExpiredTab : Fragment() {

    private lateinit var binding : FragmentExpiredTabBinding
    private lateinit var expiredPointAdapter: ExpiredPointAdapter
    private lateinit var recyclerView : RecyclerView

    companion object{
        var activityName = ""
        fun newInstance(a: String): FragmentExpiredTab{
            var args = Bundle()
            val fragment = FragmentExpiredTab()
            fragment.arguments = args
            activityName = a
            return fragment
        }
    }
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

        val data : ArrayList<ExpiredPointData> = arrayListOf(
            ExpiredPointData(R.drawable.logo_sc,R.drawable.ic_admin_point,"10 Aug 22 02:30 PM","Khin Thein",
                "","မန်ဘာလယ်ဗယ် သက်တမ်းကုန်ဆုံးသွားပါသည်","Silver to Gold","","",
                "","",false),
            ExpiredPointData(R.drawable.logo_oway,R.drawable.ic_admin_point_red,"2 Feb 22 08:45 AM","Aye Mi San",
                "566,787","မန်ဘာပွိုင့်များ သက်တမ်းကုန်ဆုံးသွားပါသည်","","","",
                "","",false)
        )
        val dataShopHistory : ArrayList<ExpiredPointData> = arrayListOf(
            ExpiredPointData(R.drawable.ic_admin_point,R.drawable.ic_admin_point,"10 Aug 22 02:30 PM","Khin Thein",
                "","မန်ဘာလယ်ဗယ် သက်တမ်းကုန်ဆုံးသွားပါသည်","Silver to Gold","","",
                "","",false),
            ExpiredPointData(R.drawable.ic_admin_point_red,R.drawable.ic_admin_point_red,"2 Feb 22 08:45 AM","Aye Mi San",
                "566,787","မန်ဘာပွိုင့်များ သက်တမ်းကုန်ဆုံးသွားပါသည်","","","",
                "","",false)
        )
        if(activityName == "shopDetailPoint"){
            binding.rvExpiredPoint.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = ExpiredPointAdapter(dataShopHistory, activityName)
            }
        }else{
            binding.rvExpiredPoint.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = ExpiredPointAdapter(data,activityName)
            }
        }

    }



}