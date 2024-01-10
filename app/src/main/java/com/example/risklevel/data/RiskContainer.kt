package com.example.risklevel.data

import com.example.risklevel.utils.SessionManager

interface AppContainer {
    val riskRepository: RiskRepository
}

class RiskContainer(override val riskRepository: RiskRepository) : AppContainer {
}