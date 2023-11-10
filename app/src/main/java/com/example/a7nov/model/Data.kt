package com.example.a7nov.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("result")
    val results : List<HeroData>



)

data class HeroData(
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title:String,
    @SerializedName("image")
    val image:String,
)
