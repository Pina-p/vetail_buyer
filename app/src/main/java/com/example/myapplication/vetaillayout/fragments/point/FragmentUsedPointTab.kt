package com.exam.homepage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ReceivedPointAdapter
import com.example.myapplication.vetaillayout.adapters.UsedPointAdapter
import com.example.myapplication.vetaillayout.model.UsedPointData
import com.example.myapplication.vetaillayout.databinding.FragmentUsedPointTabBinding
import com.example.myapplication.vetaillayout.model.usedPoint


class FragmentUsedPointTab : Fragment() {

    private lateinit var binding : FragmentUsedPointTabBinding
    private lateinit var usedPointAdapter: UsedPointAdapter
    private lateinit var recyclerView : RecyclerView

    companion object{
        var activityName = ""
        fun newInstance(a: String): FragmentUsedPointTab{
            var args = Bundle()
            val fragment = FragmentUsedPointTab()
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
        binding = FragmentUsedPointTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data : ArrayList<UsedPointData> = arrayListOf(
            UsedPointData(R.drawable.logo_sc,R.drawable.ic_trophy,"13 Aug 22 06:00 AM","Jit Two",
                "12,000","Wai Wai, Ahlone Branch မှ နှုတ်ယူလိုက်သည်","","","Order: 8978899",
                "50,000 Ks","အော်ဒါအတွက် ကျသင့်ငွေအစား ပွိုင့်ကို နှုတ်ယူလိုက်ပါပြီ",false),
            UsedPointData(
                R.drawable.logo_oway,R.drawable.ic_dollar_decrease,"1 min","Ba Din",
                "67,000","မန်ဘာပွိုင့်များဖြင့် ‌စျေးဝယ်ယူခဲ့သည်","","","Order: 8978899",
                "50,000 Ks","",false),
            UsedPointData(
                R.drawable.logo_oway,R.drawable.ic_buy_with_point,"1 min","Ba Din",
                "67,000","မန်ဘာပွိုင့်များဖြင့် ‌စျေးဝယ်ယူခဲ့သည်","","","Order: 8978899",
                "50,000 Ks","",false)
        )
        val dataShopHistory : ArrayList<UsedPointData> = arrayListOf(
            UsedPointData(R.drawable.ic_trophy,R.drawable.ic_trophy,"13 Aug 22 06:00 AM","Jit Two",
                "12,000","Wai Wai, Ahlone Branch မှ နှုတ်ယူလိုက်သည်","","","Order: 8978899",
                "50,000 Ks","အော်ဒါအတွက် ကျသင့်ငွေအစား ပွိုင့်ကို နှုတ်ယူလိုက်ပါပြီ",false),
            UsedPointData(
                R.drawable.ic_dollar_decrease,R.drawable.ic_dollar_decrease,"1 min","Ba Din",
                "67,000","မန်ဘာပွိုင့်များဖြင့် ‌စျေးဝယ်ယူခဲ့သည်","","","Order: 8978899",
                "50,000 Ks","",false),
            UsedPointData(
                R.drawable.ic_buy_with_point,R.drawable.ic_buy_with_point,"1 min","Ba Din",
                "67,000","မန်ဘာပွိုင့်များဖြင့် ‌စျေးဝယ်ယူခဲ့သည်","","","Order: 8978899",
                "50,000 Ks","",false)
        )
        if(FragmentReceivedPointTab.activityName == "shopDetailPoint"){
            binding.rvUsedPoint.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = UsedPointAdapter(dataShopHistory, activityName)
            }
        }else{
            binding.rvUsedPoint.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = UsedPointAdapter(data, activityName)
            }
        }
    }


}