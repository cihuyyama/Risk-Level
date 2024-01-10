package com.example.risklevel.data

import com.example.risklevel.LoginResponse
import com.example.risklevel.models.request.LoginRequest
import com.example.risklevel.utils.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.LOGIN_URL)
    fun login(
        @Body auth: LoginRequest
    ): Call<LoginResponse>
}