package com.example.a7nov.network

import com.example.a7nov.model.Data
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("character")
    fun getAllChars(): Call<Data>
}