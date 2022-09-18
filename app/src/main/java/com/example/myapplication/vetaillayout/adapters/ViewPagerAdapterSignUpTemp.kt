package com.example.myapplication.vetaillayout.adapters

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapterSignUpTemp(
    val items: ArrayList<Fragment>,
    activity:AppCompatActivity
    )
    :FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
          return items[position]
    }
}