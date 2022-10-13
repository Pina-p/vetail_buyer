package com.example.myapplication.vetaillayout.model

import com.example.myapplication.vetaillayout.R

data class LevelChangedData(
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
val levelChanged1 = LevelChangedData(R.drawable.logo_nike,R.color.black,"6 hr ago","Ko Nay Toe",
    "","မန်ဘာအဆင့် တက်သွားသည်","Silver to Gold","","",
    "","အမြဲအားပေးတဲ့အတွက် လယ်ဗယ်လေး တင်ပေးလိုက်ပါတယ်ရှင်")

val levelChanged2 = LevelChangedData(R.drawable.logo_ruby,R.color.black,"23 hr ago","Tin Sein",
    "","မန်ဘာအဆင့် ကျသွားသည်","Platinum to Normal","","",
    "","")

val levelChanged = arrayListOf<LevelChangedData>(
    levelChanged1, levelChanged2
)
