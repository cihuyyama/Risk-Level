package com.example.risklevel

import android.app.Application
import com.example.risklevel.data.AppContainer
import com.example.risklevel.data.RiskContainer

class RiskApplication :Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = RiskContainer()
    }
}