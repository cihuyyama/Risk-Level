package com.example.risklevel.data

import com.example.risklevel.models.request.LoginRequest
import com.example.risklevel.models.response.LoginResponse
import com.example.risklevel.utils.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.LOGIN_URL)
    fun login(
        @Body auth: LoginRequest
    ): Call<LoginResponse>

    @GET("users")
    fun getUser(): Call<User>
}