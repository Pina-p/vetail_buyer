package com.example.myapplication.vetaillayout.model

import com.example.myapplication.vetaillayout.R

data class UsedPointData(
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
val usedPoint1 =
    UsedPointData(R.drawable.logo_nike,R.color.black,"1 hr ago","Aye Sein",
        "40,000","ဆုလက်ဆောင်လဲလှယ်လိုက်သည်","","Bangkokk Flight 30% off","",
        "","",false)


val usedPoint2 = UsedPointData(R.drawable.logo_sc,R.color.black,"13 Aug 22 06:00 AM","Jit Two",
    "12,000","Wai Wai, Ahlone Branch မှ နှုတ်ယူလိုက်သည်","","","Order: 8978899",
    "50,000 Ks","အော်ဒါအတွက် ကျသင့်ငွေအစား ပွိုင့်ကို နှုတ်ယူလိုက်ပါပြီ",false)

val usedPoint3 =  UsedPointData(
    R.drawable.logo_oway,R.color.black,"1 min","Ba Din",
    "67,000","မန်ဘာပွိုင့်များဖြင့် ‌စျေးဝယ်ယူခဲ့သည်","","","Order: 8978899",
    "50,000 Ks","",false)

val usedPoint = arrayListOf<UsedPointData>(
    usedPoint1, usedPoint2, usedPoint3
)
