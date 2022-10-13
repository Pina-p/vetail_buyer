package com.example.myapplication.vetaillayout.model

import com.example.myapplication.vetaillayout.R

data class ExpiredPointData(
    val profile : Int,
    val subProfile : Int,
    val time : String,
    val name : String,
    val point : String,
    val message : String,
    val changedLevel : String,
    val discount : String,
    val orderId : String,
    val money : String,
    val comment : String,
    val isReceive : Boolean
)
val expiredPoint1 = ExpiredPointData(R.drawable.logo_sc,R.color.black,"10 Aug 22 02:30 PM","Khin Thein",
    "","မန်ဘာလယ်ဗယ် သက်တမ်းကုန်ဆုံးသွားပါသည်","Silver to Gold","","",
    "","",false)

val expiredPoint2 = ExpiredPointData(R.drawable.logo_oway,R.color.black,"2 Feb 22 08:45 AM","Aye Mi San",
    "566,787","မန်ဘာပွိုင့်များ သက်တမ်းကုန်ဆုံးသွားပါသည်","","","",
    "","",false)

val expiredPoint = arrayListOf<ExpiredPointData>(
    expiredPoint1, expiredPoint2
)
