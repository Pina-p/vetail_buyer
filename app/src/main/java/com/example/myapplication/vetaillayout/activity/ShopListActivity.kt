package com.example.myapplication.vetaillayout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.adapters.ShopListAdapter
import com.example.myapplication.vetaillayout.databinding.ActivityShopListBinding
import com.example.myapplication.vetaillayout.model.AllShops
import com.example.myapplication.vetaillayout.model.ShopList
import com.example.myapplication.vetaillayout.model.ShopListItems

class ShopListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopListBinding
    var tempShopList = ArrayList<ShopList>()
    var tempShopItemList = ArrayList<ShopListItems>()
    var tempShopItemList1 = ArrayList<ShopListItems>()
    var tempShopItemList2 = ArrayList<ShopListItems>()
    var imageList1=ArrayList<Int>()
    var imageList2=ArrayList<Int>()
    var imageList3=ArrayList<Int>()
    var imageListOne=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor= ContextCompat.getColor(this,R.color.yellowishYellow)
        //window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        addListOfImages()
        addShopTempItems()
        addShopTempData()
        initAdapter()
        onClicks()
    }

    private fun onClicks() {
        binding.ivScannerIcon.setOnClickListener {
            Toast.makeText(this, "Digital member car pop up", Toast.LENGTH_SHORT).show()
        }
        var allshop=AllShops(tempShopList)
        binding.cvSearchView.setOnClickListener{
        var svIntent=Intent(this@ShopListActivity,ShopListSearchActivity::class.java)
            svIntent.putExtra("shopList",allshop)
            Log.d("Yoe","we sent you ${allshop.allShop}")
            svIntent.also { startActivity(it) }
        }
    }

    fun initAdapter() {
        binding.rvShopList.layoutManager = LinearLayoutManager(this)
        binding.rvShopList.setHasFixedSize(true)
        val shopListAdapter = ShopListAdapter(tempShopList)
        binding.rvShopList.adapter = shopListAdapter
    }

    fun addListOfImages(){
        imageList1.add(R.drawable.image3)
        imageList1.add(R.drawable.image2)
        imageList1.add(R.drawable.image1)
        imageList1.add(R.drawable.image_boy_cry)
        imageList1.add(R.drawable.temp_item_nike_shoes)
        imageList1.add(R.drawable.image1)
        imageList1.add(R.drawable.image2)
        imageList1.add(R.drawable.image_boy_cry)
        imageList1.add(R.drawable.ic_bg_people_discussing)

        imageList2.add(R.drawable.image1)
        imageList2.add(R.drawable.image2)
        imageList2.add(R.drawable.image_boy_cry)
        imageList2.add(R.drawable.image_boy_cry)
        imageList2.add(R.drawable.image_boy_cry)
        imageList2.add(R.drawable.ic_bg_people_discussing)

        imageList3.add(R.drawable.image_boy_cry)
        imageList3.addAll(imageList1)
        imageList3.addAll(imageList2)

        imageListOne.add(R.drawable.sweetie)
        imageListOne.add(R.drawable.image2)
        imageListOne.add(R.drawable.image_boy_cry)
        imageListOne.add(R.drawable.image_boy_cry)
        imageListOne.add(R.drawable.image_boy_cry)
        imageListOne.add(R.drawable.ic_bg_people_discussing)

    }

    fun addShopTempItems() {
        tempShopItemList.add(
            ShopListItems(
                "Special Nike Air 270 new 2022",
                "350,000 Pts",
                imageListOne,
                "Hello",
                true,
                "til 14 Aug 22"
                )
        )
        tempShopItemList.add(
            ShopListItems(
                "Image 2",
                "350,00 Pts",
                imageList3,
                "walla walla bing bong",
                false,
                "til 15 Aug 22"
            )
        )
        tempShopItemList.add(
            ShopListItems(
                "Nike",
                "3,500 Pts",
                imageList2,
                "Hello",
                false,
                "til 14 Aug 22"
            )
        )
        tempShopItemList.add(
            ShopListItems(
                "Temp 270 new 2022",
                "45,000 Pts",
                imageList1,
                "Hello",
                false,
                "til 14 Aug 22"
            )
        )

        tempShopItemList1.add(
            ShopListItems(
                "270 new 2022",
                "5,000 Pts",
                imageList2,
                "Hello",
                true,
                "til 14 Aug 22"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                "Nike Air 270 new 2022",
                "350,000 Pts",
                imageList1,
                "Hello",
                true,
                "til 14 Aug 22"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                "Temp Data",
                "30,000 Pts",
                imageList2,
                "Hello",
                true,
                "til 14 Aug 22"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                "Nike Air 270 new 2022",
                "350,000 Pts",
                imageListOne,
                "Hello",
                true,
                "til 14 Aug 22"
            )
        )
        tempShopItemList1.add(
            ShopListItems(
                "Nike Air 270 new 2022",
                "350,000 Pts",
                imageList3,
                "Hello",
                true,
                "til 14 Aug 22"
            )
        )
        tempShopItemList2.add(
            ShopListItems(
                "Nike Air 270 new 2022",
                "350,000 Pts",
                imageListOne,
                "Hello",
                true,
                "til 14 Aug 22"
            )
        )
        tempShopItemList2.add(
            ShopListItems(
                "Nike Air 270 new 2022",
                "350,000 Pts",
                imageListOne,
                "Hello",
                true,
                "til 14 Aug 22"
            )

        )
    }

    fun addShopTempData() {
        tempShopList.add(
            ShopList(
                R.drawable.shop_ruby,
                "Ruby Energy Lashio",
                "35,000",
                tempShopItemList
            )
        )
        tempShopList.add(
            ShopList(
                R.drawable.logo_nike,
                "Nike Myanmar",
                "3,000",
                tempShopItemList1
            )
        )
        tempShopList.add(
            ShopList(
                R.drawable.logo_citymart,
                "City Mart",
                "20,000",
                tempShopItemList2
            )
        )
    }


}