package com.example.dompekid.data.youngsaverapi.modules

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSource
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSourceImpl
import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.repo.PocketRepoImpl
import com.example.dompekid.data.youngsaverapi.usecase.CreateNewPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetAllowancePocketOnly
import com.example.dompekid.data.youngsaverapi.usecase.GetSavingPocketOnly
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import com.example.dompekid.data.youngsaverapi.usecase.PostTopUpUseCase
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
    fun providePocketRemoteDataSource(service: YoungSaverService): PocketRemoteDataSource {
        return PocketRemoteDataSourceImpl(service)
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
    @Singleton
    @Provides
    fun provideGetSavingPocketOnly(useCase: GetAllPocketUseCase): GetSavingPocketOnly {
        return GetSavingPocketOnly(useCase)
    }
    @Singleton
    @Provides
    fun provideGetAllowancePocketOnly(useCase: GetAllPocketUseCase): GetAllowancePocketOnly {
        return GetAllowancePocketOnly(useCase)
    }

    @Singleton
    @Provides
    fun provideCreatePocketUseCase(repo: PocketRepo): CreateNewPocketUseCase {
        return CreateNewPocketUseCase(repo)
    }

    @Singleton
    @Provides
    fun providePostTopUpUseCase(repo: PocketRepo): PostTopUpUseCase {
        return PostTopUpUseCase(repo)
    }

}