package com.example.risklevel.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.risklevel.data.RiskRepository
import com.example.risklevel.data.User
import com.example.risklevel.models.request.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel(private val riskRepository: RiskRepository): ViewModel() {
    var loginState by mutableStateOf(LoginUiState())
        private set

    fun updateLoginState(loginUiEvent: LoginUiEvent) {
        loginState = LoginUiState(loginUiEvent = loginUiEvent)
    }

    suspend fun loginRisk() {
        viewModelScope.launch {
            try {
                riskRepository.login(loginState.loginUiEvent.toRisk())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

data class LoginUiState(
    val loginUiEvent: LoginUiEvent = LoginUiEvent()
)

data class LoginUiEvent(
    val email: String = "",
    val password: String = ""
)

fun LoginUiEvent.toRisk(): LoginRequest = LoginRequest(
    email = email,
    password = password
)

fun LoginRequest.toUiStateLogin(): LoginUiState = LoginUiState(
    loginUiEvent = LoginUiEvent()
)

fun LoginRequest.toLoginUiEvent(): LoginUiEvent = LoginUiEvent(
    email = email,
    password = password
)
