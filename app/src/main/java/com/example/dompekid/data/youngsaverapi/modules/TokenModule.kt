package com.example.dompekid.data.youngsaverapi.modules
import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSource
import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSourceImpl
import com.example.dompekid.data.youngsaverapi.remote.TokenRemoteDataSource
import com.example.dompekid.data.youngsaverapi.remote.TokenRemoteDataSourceImpl
import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.repo.PocketRepoImpl
import com.example.dompekid.data.youngsaverapi.repo.TokenRepo
import com.example.dompekid.data.youngsaverapi.repo.TokenRepoImpl
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TokenModule {
    @Singleton
    @Provides
    fun provideTokenRemoteDataSource(service: YoungSaverService): TokenRemoteDataSource {
        return TokenRemoteDataSourceImpl(service)
    }
    @Singleton
    @Provides
    fun provideTokenRepository(dataSource: TokenRemoteDataSource): TokenRepo {
        return TokenRepoImpl(dataSource)
    }
    @Singleton
    @Provides
    fun provideGetTokenUseCase(repo: TokenRepo): GetTokenUseCase {
        return GetTokenUseCase(repo)
    }
}