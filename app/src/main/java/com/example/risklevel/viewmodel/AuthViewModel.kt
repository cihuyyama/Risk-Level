package com.example.risklevel.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.risklevel.Repository.AuthRepository
import com.example.risklevel.models.LoginModel
import com.example.risklevel.models.response.LoginResponse
import com.example.risklevel.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
): BaseViewModel() {

    private val _loginResponse = MutableLiveData<ApiResponse<LoginResponse>>()
    val loginResponse = _loginResponse

    fun login(auth: LoginModel, coroutinesErrorHandler: CoroutinesErrorHandler) = baseRequest(
        _loginResponse,
        coroutinesErrorHandler
    ) {
        authRepository.login(auth)
    }
}