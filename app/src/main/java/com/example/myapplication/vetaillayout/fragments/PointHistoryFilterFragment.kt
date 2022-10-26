package com.example.myapplication.vetaillayout.fragments

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.toColor
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.exam.homepage.adapter.ShopAutoFillAdapter
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.FragmentPointHistoryFilterBinding
import com.example.myapplication.vetaillayout.model.MyShops
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textview.MaterialTextView
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.fixedRateTimer

class PointHistoryFilterFragment : BottomSheetDialogFragment(),AdapterView.OnItemSelectedListener {

    val TAG = "PointHistoryFilter"


    //to rounded top corner of bottom sheet fragment and write inside the theme (Style)
    override fun getTheme() = R.style.NoBackGroundDialogTheme

    private lateinit var binding : FragmentPointHistoryFilterBinding


    private lateinit var tvStartDate : TextView
    private lateinit var tvEndDate : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPointHistoryFilterBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.materialSpinner.setOnTouchListener(View.OnTouchListener { v, event ->
//            if (MotionEvent.ACTION_UP == event.action) {
//                binding.materialSpinner.endIconDrawable =
//                    resources.getDrawable(R.drawable.ic_blue_arrow_up)
//            }
//            true // return is important...
//        })
        var shops = ArrayList<MyShops>()
        //shop dropdowon data setup for step 3
//        val shop = resources.getStringArray(R.array.shop)
//        val adapter = ArrayAdapter<String>(requireActivity(),R.layout.drop_down_item, shop)
//        binding.autoComplete.threshold =0
//        binding.autoComplete.setAdapter(adapter)

//        //for search with product autocomplete textview
        shops.add(MyShops(0,R.drawable.logo_ruby,"Ruby Energy"))
        shops.add(MyShops(1,R.drawable.logo_oway,"Oway"))
        shops.add(MyShops(2,R.drawable.logo_nike,"Nike Official Myanmar"))
        shops.add(MyShops(3,R.drawable.logo_citymart,"City Mart"))

        val shopAdapter = ShopAutoFillAdapter(requireActivity(),R.layout.dropdown_shop,shops)
        binding.autoComplete.threshold =0
        binding.autoComplete.setAdapter(shopAdapter)

//        productList.add(ProductData(0,R.color.background,"","Mixed Fruit","SKU 348585"))
//        productList.add(ProductData(1,R.color.background,"ဆုလက်ဆောင်","Fruit I don't know","SKU 348585"))
//        productList.add(ProductData(2,R.color.background,"","Sunkit","SKU 348585"))
//        productList.add(ProductData(3,R.color.background,"ဆုလက်ဆောင်","Strawberry","SKU 348585"))
//        productList.add(ProductData(4,R.color.background,"","Grape","SKU 348585"))
//        val productAdapter = ProductAutoFillAdapter(requireActivity(),R.layout.search_with_product_card, productList)
//        binding.autoSearchWithProduct.setAdapter(productAdapter)




        //for choose date from Calender
        tvStartDate= view.findViewById(R.id.tvStartDate)
        tvEndDate = view.findViewById(R.id.tvEndDate)

        val myCalendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog.OnDateSetListener{view, year,month,dayOfMonth ->
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.YEAR,year)
            upDateLavel(myCalendar)
        }


        val datePickerDialog2 = DatePickerDialog.OnDateSetListener{view, year,month,dayOfMonth ->
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.YEAR,year)
            upDateLavel2(myCalendar)
        }


        tvEndDate.setOnClickListener {
             DatePickerDialog(view.context,datePickerDialog,myCalendar.get(Calendar.YEAR),
                 myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        tvStartDate.setOnClickListener {
            DatePickerDialog(view.context,datePickerDialog2,myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

       binding.autoComplete.onItemSelectedListener = this

//        binding.autoComplete.doAfterTextChanged {
//            if (it!!.isNotEmpty()){
//                binding.ivDeleteFilter.isVisible=true
//                binding.materialSpinner.setEndIconDrawable(R.drawable.ic_cancel_filter)
//            }else{
//                binding.ivDeleteFilter.isVisible=false
//                binding.materialSpinner.setEndIconDrawable(R.drawable.ic_dropdown)
//            }
//        }


    }
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        when (view?.id) {
            1 -> binding.materialSpinner.setEndIconDrawable(R.drawable.ic_cancel_filter)
            0 -> Log.d(TAG, "onItemSelected: working")
            else -> {

            }
        }
    }

    //for add selected date to textview
    private fun upDateLavel(myCalendar: Calendar) {
        val myFormat = "dd MMM yy"
        val sdf=SimpleDateFormat(myFormat,Locale.UK)
        tvEndDate.setText(sdf.format(myCalendar.time))
        if(binding.autoComplete.text.toString().isNotEmpty()&& binding.tvStartDate.text.toString().isNotEmpty()
            && binding.tvEndDate.text.toString().isNotEmpty()){
            binding.ivDeleteFilter.visibility = View.VISIBLE
        }
        binding.tvEndDate.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_cancel_filter,0)
    }
    private fun upDateLavel2(myCalendar: Calendar) {
        val myFormat = "dd MMM yy"
        val sdf=SimpleDateFormat(myFormat,Locale.UK)
        tvStartDate.setText(sdf.format(myCalendar.time))


        binding.tvStartDate.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_cancel_filter,0)
   }

}