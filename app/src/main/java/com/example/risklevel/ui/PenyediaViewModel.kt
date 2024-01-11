package com.example.risklevel.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.risklevel.RiskApplication
import com.example.risklevel.ui.auth.LoginViewModel


object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            LoginViewModel(riskApplication().container.riskRepository)
        }
    }
}

fun CreationExtras.riskApplication(): RiskApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RiskApplication)