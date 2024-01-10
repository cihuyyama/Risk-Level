package com.example.risklevel

import com.example.risklevel.models.LoginModel
import com.example.risklevel.models.response.LoginResponse
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceTest {
    @GET("kontak")
    fun getAllKontak(): Call<KontakList>

    @POST("users/login")
    fun login( @Body auth: LoginModel): Call<LoginResponse>
}
