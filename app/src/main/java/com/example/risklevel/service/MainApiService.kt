package com.example.risklevel.service

import com.example.risklevel.models.response.UserInfoResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainApiService {
    @GET("users")
    suspend fun getInfoUser(): Response<UserInfoResponse>
}