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
import com.example.myapplication.vetaillayout.adapters.UsedPointAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentRankingTabBinding
import com.example.myapplication.vetaillayout.model.LevelChangedData
import com.example.myapplication.vetaillayout.model.levelChanged


class FragmentRankingTab : Fragment() {

    private lateinit var binding : FragmentRankingTabBinding
    private lateinit var levelChangedAdapter: RankChangedAdapter
    private lateinit var recyclerView : RecyclerView

    companion object{
        var activityName = ""
        fun newInstance(a: String): FragmentRankingTab{
            var args = Bundle()
            val fragment = FragmentRankingTab()
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
        binding = FragmentRankingTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data : ArrayList<LevelChangedData> = arrayListOf(
            LevelChangedData(R.drawable.logo_nike,R.drawable.ic_increase,"6 hr ago","Ko Nay Toe",
                "","မန်ဘာအဆင့် တက်သွားသည်","Silver to Gold","","",
                "","အမြဲအားပေးတဲ့အတွက် လယ်ဗယ်လေး တင်ပေးလိုက်ပါတယ်ရှင်"),
            LevelChangedData(R.drawable.logo_ruby,R.drawable.ic_decrease,"23 hr ago","Tin Sein",
                "","မန်ဘာအဆင့် ကျသွားသည်","Platinum to Normal","","",
                "","")
        )
        val dataShopHistory : ArrayList<LevelChangedData> = arrayListOf(
            LevelChangedData(R.drawable.ic_increase,R.drawable.ic_increase,"6 hr ago","Ko Nay Toe",
                "","မန်ဘာအဆင့် တက်သွားသည်","Silver to Gold","","",
                "","အမြဲအားပေးတဲ့အတွက် လယ်ဗယ်လေး တင်ပေးလိုက်ပါတယ်ရှင်"),
            LevelChangedData(R.drawable.ic_decrease,R.drawable.ic_decrease,"23 hr ago","Tin Sein",
                "","မန်ဘာအဆင့် ကျသွားသည်","Platinum to Normal","","",
                "","")
        )
        if(FragmentReceivedPointTab.activityName == "shopDetailPoint"){
            binding.rvLevelChanged.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = RankChangedAdapter(dataShopHistory, activityName)
            }
        }else{
            binding.rvLevelChanged.apply{
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(activity)
                adapter = RankChangedAdapter(data, activityName)
            }
        }
    }


}