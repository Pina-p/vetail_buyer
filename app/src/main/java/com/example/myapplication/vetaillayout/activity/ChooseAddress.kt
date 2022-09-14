package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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
            Address("Home","Orchid Condo, Ahlone\nYangon","တိုယိုတာကားစင်တာ အနီး"),
            Address("Work","No 55, General Street,\nKamaryut,Yangon","တရုတ်ဘုရေားကျောင်းရှေ့")
        )

        binding.rvAddress.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ChooseAddress)
            adapter = AddressAdapter(data)
        }

        binding.ivBackButton.setOnClickListener {
            finish()
        }
    }
}