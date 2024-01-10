package com.example.risklevel

import com.example.risklevel.Repository.AuthRepository
import com.example.risklevel.Repository.MainRepository
import com.example.risklevel.service.AuthApiService
import com.example.risklevel.service.MainApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class HiltModule {

    @Provides
    fun provideAuthRepository(authApiService: AuthApiService) = AuthRepository(authApiService)

    @Provides
    fun provideMainRepository(mainApiService: MainApiService) = MainRepository(mainApiService)
}