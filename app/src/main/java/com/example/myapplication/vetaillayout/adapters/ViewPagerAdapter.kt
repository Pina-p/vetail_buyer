package com.example.myapplication.vetaillayout.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.vetaillayout.R


class ViewPagerAdapter(var context: Context) : PagerAdapter() {
    var images = intArrayOf(
        R.drawable.ic_bg_people_discussing,
        R.drawable.ic_bg_twopeople,
        R.drawable.ic_bg_onepeople
    )

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.item_welcome_layout, container, false)
        val slidetitleimage = view.findViewById<View>(R.id.ivLayoutIcon) as ImageView
        slidetitleimage.setImageResource(images[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}
