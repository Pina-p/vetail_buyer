package com.example.myapplication.vetaillayout.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivityProfileBinding
import java.util.*


class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfileImg.load(R.drawable.naruto_profile){
            crossfade(true)
            crossfade(1000)
            transformations(CircleCropTransformation())
        }

        binding.ivForwardArrow.setOnClickListener {
            Intent(this,SecuritySettingActivity::class.java).also { startActivity(it) }
        }

        binding.ivEdit.setOnClickListener {
            Intent(this,ChangeUserNameAndImage::class.java).also { startActivity(it) }
        }

        binding.ivArrowBirth.setOnClickListener {
            // Get Current Date
            var c = Calendar.getInstance();
            var mYear = c.get(Calendar.YEAR);
            var mMonth = c.get(Calendar.MONTH);
            var mDay = c.get(Calendar.DAY_OF_MONTH);
            val datePickerDialog = DatePickerDialog(this,
                { view, year, monthOfYear, dayOfMonth ->  },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
            datePickerDialog.setTitle("Friday")

        }
        binding.ivArrowPhoneNum.setOnClickListener {
            Intent(this,ChangePhoneNum::class.java).also { startActivity(it) }
        }

        binding.ivArrowMail.setOnClickListener {
            Intent(this,ConnectWithEmail::class.java).also { startActivity(it) }
        }

        binding.ivArrowAddr.setOnClickListener {
            Intent(this,ChooseAddress::class.java).also { startActivity(it) }
        }
    }

}