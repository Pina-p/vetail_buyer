package com.example.myapplication.vetaillayout.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.fragments.SignUpOneFragment
import com.example.myapplication.vetaillayout.fragments.SignUpTwoFragment

class ViewPagerAdapterSignUp(val changeLayout:Int)
    :RecyclerView.Adapter<ViewPagerAdapterSignUp.ViewPagerViewHolder>() {

        inner class ViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val viewOne=LayoutInflater.from(parent.context).inflate(R.layout.item_signin_one,parent,false)
        val viewTwo=LayoutInflater.from(parent.context).inflate(R.layout.item_signin_two,parent,false)
        when (changeLayout) {
            0 -> {
                return ViewPagerViewHolder(viewOne)
            }
            1 -> {
                return ViewPagerViewHolder(viewTwo)
            }
            else -> {
                return ViewPagerViewHolder(viewOne)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.itemView.findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            Toast.makeText(holder.itemView.context, "This was really clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
       return 2
    }
}
//    val layoutOne =R.layout.fragment_sign_up_one
//    val layoutTwo=R.layout.item_signin_two
//    var layoutArray= arrayListOf<Int>(layoutOne,layoutTwo)
//    override fun getCount(): Int {
//        return layoutArray.size
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view === `object` as ConstraintLayout
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val layoutInflater =
//            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val viewOne: View = layoutInflater.inflate(layoutOne, container, false)
//        val viewTwo: View = layoutInflater.inflate(layoutTwo,container,false)
//        container.addView(viewOne)
//        container.addView(viewTwo)
//        return container
//    }
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as ConstraintLayout)
//    }
//
//}