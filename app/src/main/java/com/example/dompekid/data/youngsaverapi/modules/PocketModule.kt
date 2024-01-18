package com.example.dompekid.data.youngsaverapi.modules

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSource
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSourceImpl
import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.repo.PocketRepoImpl
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PocketModule {
    @Singleton
    @Provides
    fun providePocketRemoteDataSource(service: YoungSaverService,token:GetTokenUseCase): PocketRemoteDataSource {
        return PocketRemoteDataSourceImpl(service,token)
    }
    @Singleton
    @Provides
    fun providePocketRepository(dataSource: PocketRemoteDataSource): PocketRepo {
        return PocketRepoImpl(dataSource)
    }
    @Singleton
    @Provides
    fun provideGetAllPocketUseCase(repo: PocketRepo): GetAllPocketUseCase {
        return GetAllPocketUseCase(repo)
    }
}