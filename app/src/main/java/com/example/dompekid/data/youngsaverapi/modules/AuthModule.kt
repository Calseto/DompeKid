package com.example.dompekid.data.youngsaverapi.modules
import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.remote.AuthRemoteDataSource
import com.example.dompekid.data.youngsaverapi.remote.AuthRemoteDataSourceImpl
import com.example.dompekid.data.youngsaverapi.repo.AuthRepo
import com.example.dompekid.data.youngsaverapi.repo.AuthRepoImpl
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.data.youngsaverapi.usecase.CreateAccountUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetSavingPocketOnly
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import com.example.dompekid.data.youngsaverapi.usecase.RequestRegistration
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Singleton
    @Provides
    fun provideTokenRemoteDataSource(service: YoungSaverService): AuthRemoteDataSource {
        return AuthRemoteDataSourceImpl(service)
    }
    @Singleton
    @Provides
    fun provideTokenRepository(dataSource: AuthRemoteDataSource): AuthRepo {
        return AuthRepoImpl(dataSource)
    }
    @Singleton
    @Provides
    fun provideGetTokenUseCase(repo: AuthRepo): GetTokenUseCase {
        return GetTokenUseCase(repo)
    }
    @Singleton
    @Provides
    fun provideCreateAccountUseCase(repo: AuthRepo): CreateAccountUseCase {
        return CreateAccountUseCase(repo)
    }
    @Singleton
    @Provides
    fun provideRequestRegisUseCase(repo: AuthRepo): RequestRegistration {
        return RequestRegistration(repo)
    }


}