package com.example.myapplication.vetaillayout.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShopList(
    val shopIcon:Int,
    val shopName:String,
    val myPoints:String,
    val shopListItems:List<ShopListItems>
):Parcelable
