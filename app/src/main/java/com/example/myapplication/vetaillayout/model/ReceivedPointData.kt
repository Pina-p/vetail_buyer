package com.example.myapplication.vetaillayout.model

import com.example.myapplication.vetaillayout.R

data class ReceivedPointData(
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
    val comment : String
)
val receivedPoint1 = ReceivedPointData(
    R.drawable.logo_ruby,R.color.black,"1 min","Ruby Energy",
    "+5,000","Aung Soe, Admin ထံမှရရှိပါသည်","","","Order: 8978899",
    "50,000 Ks","အင်ဂျင်ဝိုင် ဝယ်ယူသည့်အတွက် လက်ဆောင်ပွိုင့်လေးရပါတယ်ခင်ဗျ")

val receivedPoint2 = ReceivedPointData(R.drawable.logo_nike,R.color.black,"3 min","Nike",
    "+120,000","စျေးဝယ်သည့်အတွက်ရရှိပါသည်","","","Order: 8978899",
    "50,000 Ks","")


val receivedPoint = arrayListOf<ReceivedPointData>(
    receivedPoint1, receivedPoint2
)
