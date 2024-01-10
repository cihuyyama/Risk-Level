package com.example.risklevel

import android.app.Application
import com.example.risklevel.data.ApiClient
import com.example.risklevel.data.AppContainer
import com.example.risklevel.data.RiskContainer
import com.example.risklevel.utils.SessionManager

class RiskApplication :Application() {
    private lateinit var apiClient: ApiClient
    private lateinit var sessionManager: SessionManager
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        apiClient = ApiClient()
        sessionManager = SessionManager(this)
    }
}