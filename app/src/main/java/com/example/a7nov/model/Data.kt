package com.example.a7nov.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("results")
    val `results` : List<RickData>



)

data class RickData(
    @SerializedName("id")
    val `id`:Int,
    @SerializedName("name")
    val `name`:String,
    @SerializedName("species")
    val `species`:String,
)
