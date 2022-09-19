package com.example.myapplication.vetaillayout.model

data class ShopList(
    val shopIcon:Int,
    val shopName:String,
    val myPoints:String,
    val shopItems:List<ShopListItems>
)
