package com.exam.homepage.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.RankChangedAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentRankingTabBinding
import com.example.myapplication.vetaillayout.model.LevelChangedData


class FragmentRankingTab : Fragment() {

    private lateinit var binding : FragmentRankingTabBinding
    private lateinit var levelChangedAdapter: RankChangedAdapter
    private lateinit var recyclerView : RecyclerView
    var levelChangedList = ArrayList<LevelChangedData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRankingTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addHistoryData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView= view.findViewById(R.id.rvLevelChanged)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)
        levelChangedAdapter = RankChangedAdapter(levelChangedList)
        recyclerView.adapter = levelChangedAdapter
    }

    fun addHistoryData(){
        levelChangedList.add(
            LevelChangedData(R.drawable.logo_nike,R.color.black,"6 hr ago","Ko Nay Toe",
                "","မန်ဘာအဆင့် တက်သွားသည်","Silver to Gold","","",
                "","အမြဲအားပေးတဲ့အတွက် လယ်ဗယ်လေး တင်ပေးလိုက်ပါတယ်ရှင်")
        )

        levelChangedList.add(
            LevelChangedData(R.drawable.logo_ruby,R.color.black,"23 hr ago","Tin Sein",
                "","မန်ဘာအဆင့် ကျသွားသည်","Platinum to Normal","","",
                "","")
        )

    }

}