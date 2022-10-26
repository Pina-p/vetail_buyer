package com.example.myapplication.vetaillayout.activity

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.CircleCropTransformation
import com.exam.homepage.SwitchAccBottomsheet
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ProfileMyShopsAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityProfileBinding
import com.example.myapplication.vetaillayout.model.MyShops
import java.util.*


class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shops: ArrayList<MyShops> = arrayListOf(
            MyShops(1,R.drawable.sweetie,"Sweetie Beauty & Spa"),
            MyShops(2,R.drawable.spicy_pot,"Mala King Hotpot & BBQ"),
            MyShops(3,R.drawable.your_deli,"SONIC  Delivery"),
            MyShops(4,R.drawable.pink_r,"Sweetie Beauty & Spa"),
            MyShops(4,R.drawable.pink_r,"Sweetie Beauty & Spa"),

        )
        binding.ivProfileImg.load(R.drawable.naruto_profile){
            crossfade(true)
            crossfade(1000)
            transformations(CircleCropTransformation())
        }

        binding.rvMyShops.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ProfileActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter = ProfileMyShopsAdapter(shops)
        }
        binding.ivCuteProfile.setOnClickListener {
            var bottomSheetFragment = SwitchAccBottomsheet()
            bottomSheetFragment.show(supportFragmentManager,"Add Shop Category Bottom Sheet")
        }

        binding.ivForwardArrow.setOnClickListener {
            Intent(this,SecuritySettingActivity::class.java).also { startActivity(it) }
        }

        binding.ivEdit.setOnClickListener {
            Intent(this,ChangeUserNameAndImage::class.java).also { startActivity(it) }
        }

        binding.tvConnect.setOnClickListener {
            Intent(this,ConnectWithEmail::class.java).also { startActivity(it) }
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

        binding.tvExitAcc.setOnClickListener {
            Intent(this,AccountLogoutActivity::class.java).also { startActivity(it) }
        }
    }

}