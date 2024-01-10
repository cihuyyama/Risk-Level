package com.example.risklevel.service

import com.example.risklevel.data.User
import com.example.risklevel.models.request.LoginRequest
import retrofit2.http.GET
import retrofit2.http.POST

interface RiskService {
    @POST("users/login")
    suspend fun login(auth: LoginRequest)

    @GET("users")
    suspend fun getUser(): User
}