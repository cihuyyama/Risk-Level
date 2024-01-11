package com.example.risklevel.data

import com.example.risklevel.models.request.LoginRequest
import com.example.risklevel.models.response.LoginResponse

interface RiskRepository{
    suspend fun login(auth: LoginRequest): LoginResponse?
    suspend fun getUser(): User?
}

class NetworkRiskRepository(
    private val riskApiService: ApiService
): RiskRepository {
    override suspend fun login(auth: LoginRequest): LoginResponse? {
        val response = riskApiService.login(auth).execute()
        return response.body()
    }

    override suspend fun getUser(): User? {
        val response = riskApiService.getUser().execute()
        return response.body()
    }

}