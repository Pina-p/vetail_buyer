package com.example.myapplication.vetaillayout.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.AccountAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentLogoutBinding
import com.example.myapplication.vetaillayout.model.Account

class AccountLogoutActivity : AppCompatActivity() {
    private lateinit var binding: FragmentLogoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLogoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data : ArrayList<Account> = arrayListOf(
            Account(R.drawable.naruto_profile,"Jobby James")
        )

        binding.rvAcc.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@AccountLogoutActivity)
            adapter = AccountAdapter(data)
        }
    }
}