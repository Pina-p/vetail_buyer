package com.example.myapplication.vetaillayout.model

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
