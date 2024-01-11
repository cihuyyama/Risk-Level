package com.example.risklevel.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val riskRepository: RiskRepository
}

class RiskContainer : AppContainer {
    private val baseUrl = "http://10.0.2.2:8080/api/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    private val riskService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
    override val riskRepository: RiskRepository by lazy {
        NetworkRiskRepository(riskService)
    }
}