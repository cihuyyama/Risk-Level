package com.example.risklevel.Repository

import com.example.risklevel.models.LoginModel
import com.example.risklevel.service.AuthApiService
import com.example.risklevel.utils.apiRequestFlow
import javax.inject.Inject

class AuthRepository @Inject constructor (
    private val authService: AuthApiService
) {
    fun login(auth: LoginModel) = apiRequestFlow {
        authService.login(auth)
    }
}