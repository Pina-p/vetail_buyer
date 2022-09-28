package com.example.myapplication.vetaillayout.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.FragmentAddNewAddrBinding
import com.google.android.material.chip.Chip

class FragmentAddNewAddr : Fragment() {
    private lateinit var binding : FragmentAddNewAddrBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewAddrBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cities = resources.getStringArray(R.array.cities)
        val adapter = ArrayAdapter<String>(requireActivity(),R.layout.dropdown_item,cities)
        binding.autoComplete.setAdapter(adapter)

        val towns = resources.getStringArray(R.array.towns)
        val t_adapter = ArrayAdapter<String>(requireActivity(),R.layout.dropdown_item,towns)
        binding.autoCompleteTown.setAdapter(t_adapter)

        binding.autoComplete.doAfterTextChanged {
            if(binding.autoComplete.text.toString().isNotEmpty()){
                binding.materialSpinnerTown.visibility = View.VISIBLE
            }
        }

        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->

                val chip: Chip? =
                    group.findViewById(checkedId)

                chip?.let {
                    val chipText = chip.text.toString()
                    Log.d("Chip", "onViewCreated: $chipText")
                    if(chipText == "အိမ်"){
                        binding.etOther.visibility = View.GONE
                        binding.cardText.visibility = View.VISIBLE
                        binding.chipHome.setChipIconTintResource(R.color.white)
                        binding.chipWork.setChipIconTintResource(R.color.icon_color)
                        binding.chipOther.setChipIconTintResource(R.color.icon_color)
                        binding.tvConfirmText.setText("\"အိမ်\"ဖြင့် အခြားလိပ်စာတစ်ခုအား ရွေးချယ်ထားပြီးဖြစ်သည်။ ယခုထည့်သွင်းနေသော လိပ်စာအသစ်အား\"အိမ်\"အဖြစ် ပြောင်းလဲရန် သေချာပါသလား?")
                        binding.etOther.setTextColor(resources.getColor(R.color.blueFont))
                    }else if(chipText == "အလုပ်"){
                        binding.etOther.visibility = View.GONE
                        binding.cardText.visibility = View.VISIBLE
                        binding.chipWork.setChipIconTintResource(R.color.white)
                        binding.chipHome.setChipIconTintResource(R.color.icon_color)
                        binding.chipOther.setChipIconTintResource(R.color.icon_color)
                        binding.tvConfirmText.setText("\"အလုပ်\"ဖြင့် အခြားလိပ်စာတစ်ခုအား ရွေးချယ်ထားပြီးဖြစ်သည်။ ယခုထည့်သွင်းနေသော လိပ်စာအသစ်အား\"အလုပ်\"အဖြစ် ပြောင်းလဲရန် သေချာပါသလား?")
                        binding.etOther.setTextColor(resources.getColor(R.color.blueFont))
                    }
                    else{
                        binding.cardText.visibility = View.GONE
                        binding.etOther.visibility = View.VISIBLE
                        binding.chipOther.setChipIconTintResource(R.color.white)
                        binding.chipWork.setChipIconTintResource(R.color.icon_color)
                        binding.chipHome.setChipIconTintResource(R.color.icon_color)
//                        binding.etOther.setText("")
//                        binding.etOther.setHint("*ဥပမာ - ကျော်ကျော်၏ အိမ်")
//                        binding.etOther.setHintTextColor(Color.parseColor("#a5a5a5"))
                    }

                }
            }

    }
}