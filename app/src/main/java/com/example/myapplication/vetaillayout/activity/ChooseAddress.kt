package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.AddressAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityChooseAddressBinding
import com.example.myapplication.vetaillayout.model.Address

class ChooseAddress : AppCompatActivity() {
    private lateinit var binding: ActivityChooseAddressBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data : ArrayList<Address> = arrayListOf(
            Address(R.drawable.home,"Home","Orchid Condo, Ahlone\nYangon","တိုယိုတာကားစင်တာ အနီး"),
            Address(R.drawable.work,"Work","No 55, General Street,\nKamaryut,Yangon","တရုတ်ဘုရားကျောင်းရှေ့")
        )

        binding.rvAddress.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ChooseAddress)
            adapter = AddressAdapter(data)
        }

        binding.ivBackButton.setOnClickListener {
            finish()
        }

        binding.ivAdd.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}