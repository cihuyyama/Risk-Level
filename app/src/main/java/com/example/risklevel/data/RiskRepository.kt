package com.example.risklevel.data

import com.example.risklevel.models.request.LoginRequest
import com.example.risklevel.service.RiskService

interface RiskRepository{
    suspend fun login(auth: LoginRequest)
    suspend fun getUser(): User
}

class NetworkRiskRepository (
    private val riskApiService: RiskService
): RiskRepository {
    override suspend fun login(auth: LoginRequest) {
        return riskApiService.login(auth)
    }

    override suspend fun getUser(): User {
        return riskApiService.getUser()
    }

}