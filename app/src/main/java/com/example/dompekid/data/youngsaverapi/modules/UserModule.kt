package com.example.dompekid.data.youngsaverapi.modules
import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSource
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSourceImpl
import com.example.dompekid.data.youngsaverapi.remote.UserDataSource
import com.example.dompekid.data.youngsaverapi.remote.UserDataSourceImpl
import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.repo.PocketRepoImpl
import com.example.dompekid.data.youngsaverapi.repo.UserDataRepo
import com.example.dompekid.data.youngsaverapi.repo.UserDataRepoImpl
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetAllowancePocketOnly
import com.example.dompekid.data.youngsaverapi.usecase.GetSavingPocketOnly
import com.example.dompekid.data.youngsaverapi.usecase.GetUserDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {
    @Singleton
    @Provides
    fun provideUserDataSource(service: YoungSaverService): UserDataSource {
        return UserDataSourceImpl(service)
    }
    @Singleton
    @Provides
    fun provideUserDataRepository(dataSource: UserDataSource): UserDataRepo {
        return UserDataRepoImpl(dataSource)
    }
    @Singleton
    @Provides
    fun provideGetUserDataUseCase(repo: UserDataRepo): GetUserDataUseCase {
        return GetUserDataUseCase(repo)
    }
}