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
        val layoutManager = LinearLayoutManager(context)

        val data : ArrayList<ReceivedPointData> = arrayListOf(
            ReceivedPointData(
                R.drawable.logo_ruby,R.color.black,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ"),
            ReceivedPointData(
                R.drawable.logo_ruby,R.color.black,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ"),
            ReceivedPointData(
                R.drawable.logo_ruby,R.color.black,"1 min","Ruby Energy",
                "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
                "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ")
        )
        recyclerView= binding.rvReceivedPointHistory // view.findViewById(R.id.rvReceivedPointHistory)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)
        receivedPointAdapter = ReceivedPointAdapter(data)
        recyclerView.adapter = receivedPointAdapter
        Log.d("OOOOOOOO", "onViewCreated: $data")

    }



}