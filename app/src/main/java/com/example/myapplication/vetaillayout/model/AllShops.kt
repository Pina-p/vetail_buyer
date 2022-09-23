package com.example.myapplication.vetaillayout.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllShops(
    var allShop:ArrayList<ShopList>
) :Parcelable
