package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ShopListAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityShopListSearchBinding
import com.example.myapplication.vetaillayout.model.AllShops
import com.example.myapplication.vetaillayout.model.ShopList
import java.util.*
import kotlin.collections.ArrayList

class ShopListSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopListSearchBinding
    private lateinit var shopListAdapter:ShopListAdapter
    private lateinit var shopList:AllShops
    private lateinit var shopListRV:ArrayList<ShopList>
    private lateinit var tempShopList: ArrayList<ShopList>
    private lateinit var tempShopListHold: ArrayList<ShopList>
    var unionNow=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityShopListSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shopList=intent.getParcelableExtra<AllShops>("shopList")!!
        shopListRV=shopList.allShop
        tempShopList=ArrayList()
        tempShopListHold=ArrayList()
        onClicks()
        initAdapter()
        textChangeListen()
    }

    fun onClicks(){
            binding.ivSearch.setOnClickListener {
                if (unionNow){
                   binding.etSearch.setText("")
                }
            }


        binding.tvClose.setOnClickListener {
            finish()
        }


    }
    fun initAdapter() {
        binding.rvShopList.layoutManager = LinearLayoutManager(this)
        binding.rvShopList.setHasFixedSize(true)
            shopListAdapter = ShopListAdapter(tempShopList)
            binding.rvShopList.adapter = shopListAdapter


    }

    fun textChangeListen(){
        var textShopList=shopListRV
        binding.etSearch.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("Yoe","Top $p0 and ${tempShopList}")
                Log.d("Yoe","Top $p0 and ${shopListRV[0].shopName}")
                if (p0.isNullOrEmpty()){
                    binding.ivSearch.setImageResource(R.drawable.ic_search_icon)
                    unionNow=false
                    tempShopList.clear()
                    shopListAdapter.notifyDataSetChanged()
                    binding.llNotFound.visibility= View.VISIBLE
                    binding.svItems.visibility=View.GONE
                }

                else{
                    tempShopList.clear()
                    binding.ivSearch.setImageResource(R.drawable.ic_union_circle)
                    unionNow=true
                    textShopList.forEach{
                        if (it.shopName.lowercase().contains(p0)) {
                            tempShopList.add(it)
                            binding.llNotFound.visibility= View.GONE
                            binding.svItems.visibility=View.VISIBLE
                        }
                    }
                    if (tempShopList.isEmpty()){
                        binding.llNotFound.visibility= View.VISIBLE
                        binding.svItems.visibility=View.GONE
                    }
                    shopListAdapter.notifyDataSetChanged()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

    }
}