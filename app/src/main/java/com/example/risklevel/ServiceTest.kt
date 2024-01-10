package com.example.risklevel

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ServiceTest {
    @GET("kontak")
    fun getAllKontak(): Call<KontakList>

    @POST("users/login")
    fun login(@Body loginModel: LoginModel): Call<LoginResponse>

    @GET("users")
    fun getUser(@Header("Authorization") token: String): Call<User>
}
