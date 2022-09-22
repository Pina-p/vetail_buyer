package com.example.myapplication.vetaillayout.model

data class ShopListItems (
    val itemName:String,
    val itemPoint:String,
    val itemImage:List<Int>,
    val aboutItem:String?=null,
    val hot:Boolean,
    val dateUntil:String
        )