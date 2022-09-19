package com.example.myapplication.vetaillayout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ShopListAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityShopListBinding
import com.example.myapplication.vetaillayout.model.ShopList
import com.example.myapplication.vetaillayout.model.ShopListItems

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopListBinding
    var tempShopList = ArrayList<ShopList>()
    var tempShopItemList = ArrayList<ShopListItems>()
    var tempShopItemList1 = ArrayList<ShopListItems>()
    var tempShopItemList2 = ArrayList<ShopListItems>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addShopTempItems()
        addShopTempData()
        initAdapter()
    }

    fun initAdapter() {
        binding.rvShopList.layoutManager = LinearLayoutManager(this)
        binding.rvShopList.setHasFixedSize(true)
        val shopListAdapter = ShopListAdapter(tempShopList)
        binding.rvShopList.adapter = shopListAdapter
    }

    fun addShopTempItems() {
        tempShopItemList.add(
            ShopListItems(
                false,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
                )
        )
        tempShopItemList.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )

        tempShopItemList1.add(
            ShopListItems(
                false,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList2.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
        tempShopItemList2.add(
            ShopListItems(
                true,
                "till 14 Aug 22",
                R.drawable.temp_item_nike_shoes,
                "Nike Air 270 new 2022",
                "350,000Pts"
            )
        )
    }

    fun addShopTempData() {
        tempShopList.add(
            ShopList(
                R.drawable.shop_ruby,
                "Ruby Energy Lashio",
                "35,000 Pts",
                tempShopItemList
            )
        )
        tempShopList.add(
            ShopList(
                R.drawable.logo_nike,
                "Nike Myanmar",
                "3,000 Pts",
                tempShopItemList1
            )
        )
        tempShopList.add(
            ShopList(
                R.drawable.logo_citymart,
                "City Mart",
                "20,000 Pts",
                tempShopItemList2
            )
        )
    }


}