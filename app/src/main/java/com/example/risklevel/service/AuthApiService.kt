package com.example.risklevel.service

import com.example.risklevel.models.LoginModel
import com.example.risklevel.models.RegisterModel
import com.example.risklevel.models.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("users/login")
    suspend fun login(
        @Body auth: LoginModel
    ): Response<LoginResponse>

    @POST("users/register")
    suspend fun register(
        @Body auth: RegisterModel
    )
}