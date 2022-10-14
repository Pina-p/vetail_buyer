package com.exam.homepage.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ReceivedPointAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentReceivedPointTabBinding
import com.example.myapplication.vetaillayout.model.ReceivedPointData
import com.example.myapplication.vetaillayout.model.receivedPoint

class FragmentReceivedPointTab : Fragment() {
    private lateinit var binding : FragmentReceivedPointTabBinding
    private lateinit var receivedPointAdapter: ReceivedPointAdapter
    private lateinit var recyclerView : RecyclerView


    companion object{
        var activityName = ""
        fun newInstance(a: String): FragmentReceivedPointTab{
            var args = Bundle()
            val fragment = FragmentReceivedPointTab()
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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReceivedPointTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataShopDetail : ArrayList<ReceivedPointData> = arrayListOf(
            ReceivedPointData(
                R.drawable.ic_admin_point,0,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ"),
            ReceivedPointData(
                R.drawable.ic_buy_point,0,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ"),
        )
        val data : ArrayList<ReceivedPointData> = arrayListOf(
            ReceivedPointData(
                R.drawable.logo_ruby,R.drawable.ic_admin_point,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ"),
            ReceivedPointData(
                R.drawable.logo_ruby,R.drawable.ic_buy_point,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ"),
            ReceivedPointData(
                R.drawable.logo_ruby,R.color.black,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ")
        )
        if(activityName == "shopDetailPoint"){
            binding.rvReceivedPointHistory.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = ReceivedPointAdapter(dataShopDetail, activityName)
            }
        }else{
            binding.rvReceivedPointHistory.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                receivedPointAdapter = ReceivedPointAdapter(data, activityName)
                adapter = receivedPointAdapter
                receivedPointAdapter.notifyDataSetChanged()
            }
        }

//        recyclerView= binding.rvReceivedPointHistory // view.findViewById(R.id.rvReceivedPointHistory)
//        recyclerView.layoutManager=layoutManager
//        recyclerView.setHasFixedSize(true)
//        receivedPointAdapter = ReceivedPointAdapter(data)
//        recyclerView.adapter = receivedPointAdapter


        Log.d("OOOOOOOO", "onViewCreated: $data")

    }

//    override fun onResume() {
//        super.onResume()
//        binding.rvReceivedPointHistory.apply {
//            setHasFixedSize(true)
//            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//            receivedPointAdapter = ReceivedPointAdapter(data)
//            adapter = receivedPointAdapter
//            receivedPointAdapter.notifyDataSetChanged()
//        }
//    }

}