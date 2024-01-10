package com.example.risklevel.Repository

import com.example.risklevel.service.MainApiService
import com.example.risklevel.utils.apiRequestFlow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val mainApiService: MainApiService,
) {
    fun getUserInfo() = apiRequestFlow {
        mainApiService.getInfoUser()
    }
}