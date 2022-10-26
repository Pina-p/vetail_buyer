package com.exam.homepage

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.homepage.adapter.SwitchAccAdapter
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.SwitchAccBottomSheetBinding
import com.example.myapplication.vetaillayout.model.Account
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SwitchAccBottomsheet : BottomSheetDialogFragment() {


    private lateinit var binding: SwitchAccBottomSheetBinding
    val accList = ArrayList<Account>()

    //to remove fragment background color and write inside the theme (Style)
    override fun getTheme() = R.style.NoBackGroundDialogTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = SwitchAccBottomSheetBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accList.add(Account(R.drawable.naruto_profile,"Jobby James"))
        accList.add(Account(R.drawable.sweetie,"Sweeties Beauty & Spa"))
        accList.add(Account(R.drawable.spicy_pot,"Mala King Hotpot & BBQ"))
        accList.add(Account(R.drawable.your_deli,"SONIC Delivery"))
        accList.add(Account(R.drawable.pink_r,"SOUVENIR Gift & Memorial"))

        binding.rvShopCategory.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = SwitchAccAdapter(accList)
        }

        binding.llNewShopBtn.setOnClickListener {

//            var bottomSheetFragment = AddShopCategoryBottomSheet()
//            bottomSheetFragment.show(parentFragmentManager,"Add Shop Category Bottom Sheet")

        }
        binding.btnLoginOtherAcc.setOnClickListener {

        }

    }


}