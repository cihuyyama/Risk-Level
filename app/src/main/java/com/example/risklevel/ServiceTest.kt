package com.example.risklevel

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface ServiceTest {
    @GET("kontak")
    fun getAllKontak(): Call<KontakList>
}
