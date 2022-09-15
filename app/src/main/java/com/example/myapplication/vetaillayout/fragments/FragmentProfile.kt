package com.example.myapplication.vetaillayout.fragments

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.*
import com.example.myapplication.vetaillayout.databinding.FragmentProfileBinding
import java.util.*

class FragmentProfile: Fragment() {
    private lateinit var binding : FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivProfileImg.load(R.drawable.naruto_profile){
            crossfade(true)
            crossfade(1000)
            transformations(CircleCropTransformation())
        }

        binding.ivForwardArrow.setOnClickListener {
            var intent = Intent(requireActivity(),SecuritySettingActivity::class.java)
            view.context.startActivity(intent)
        }

        binding.ivEdit.setOnClickListener {
            var intent = Intent(requireActivity(),ChangeUserNameAndImage::class.java)
            view.context.startActivity(intent)
        }

        binding.ivArrowBirth.setOnClickListener {
            // Get Current Date
            var c = Calendar.getInstance();
            var mYear = c.get(Calendar.YEAR);
            var mMonth = c.get(Calendar.MONTH);
            var mDay = c.get(Calendar.DAY_OF_MONTH);
            val datePickerDialog = DatePickerDialog(view.context,
                { view, year, monthOfYear, dayOfMonth ->  },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
            datePickerDialog.setTitle("Friday")

        }
        binding.ivArrowPhoneNum.setOnClickListener {
            var intent = Intent(requireActivity(),ChangePhoneNum::class.java)
            view.context.startActivity(intent)
        }

        binding.ivArrowMail.setOnClickListener {
            var intent = Intent(requireActivity(),ConnectWithEmail::class.java)
            view.context.startActivity(intent)
        }

        binding.ivArrowAddr.setOnClickListener {
            var intent = Intent(requireActivity(),ChooseAddress::class.java)
            view.context.startActivity(intent)
        }

        Log.d("Mingalar","onviewCreated")
    }
}