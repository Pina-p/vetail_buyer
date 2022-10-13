package com.exam.homepage.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.model.MyShops
import java.lang.Exception

class ShopAutoFillAdapter(val mContext : Context,
                             val mLayoutResourseId : Int,
                             sList : ArrayList<MyShops>) : ArrayAdapter<MyShops>(mContext,mLayoutResourseId,sList) {

    private val tempUnitList = ArrayList<MyShops>(sList)
    override fun getFilter(): Filter {
        return filterResult
    }

    override fun getCount(): Int {
        Log.i("TAGASGDADG", "getView: ${tempUnitList.size} ")
        return tempUnitList.size
    }

    override fun getItem(position: Int): MyShops{
        Log.i("TAGASGDADG", "getView: ${tempUnitList.size} ")
        return tempUnitList[position]
    }

    override fun getItemId(position: Int): Long {
        Log.i("TAGASGDADG", "getView: ${tempUnitList.size} ")
        return tempUnitList[position].id.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertTemp=convertView
        if (convertTemp ==null){
            val inflater= (mContext as Activity).layoutInflater
            convertTemp = inflater.inflate(mLayoutResourseId,parent,false)
        }

        try {
            val shop = getItem(position)
            val shopImage = convertTemp?.findViewById<ImageView>(R.id.ivShopLogo)
            val shopName = convertTemp?.findViewById<TextView>(R.id.tvShopName)
            val view = convertTemp?.findViewById<View>(R.id.view)
            if( position == 0){
                view?.visibility = View.GONE
            }
            shopImage?.setImageResource(shop.shopImg)

            shopName?.text=shop.shopName

        }catch (e: Exception){
            e.printStackTrace()
        }
        return convertTemp!!
    }



    val filterResult = object : Filter() {
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val result = FilterResults()
            val suggestions = ArrayList<MyShops>()

            if (p0.isNullOrEmpty()) {
                suggestions.addAll(sList)
                Log.d("Called once", "Called Once Onnce")
            } else {
                val stringPattern: String = p0.toString().lowercase().trim()
                for (item in sList) {
                    if (item.shopName.lowercase().contains(stringPattern)) {
                        suggestions.add(item)
                    }
                }

            }
            result.count = suggestions.size
            result.values = suggestions
            Log.d("Sleepy2", "Her is ${result.values}")
            return result
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            sList.clear()
            sList.addAll(p1?.values as List<MyShops>)
            notifyDataSetChanged()
            Log.d("Sleepy", "Her is ${p1.values.toString()}")

        }

        override fun convertResultToString(resultValue: Any?): CharSequence {
            val temp = resultValue as MyShops
            Log.d("Sleepy1", "Her is $temp")

            return temp.shopName

        }
    }
}