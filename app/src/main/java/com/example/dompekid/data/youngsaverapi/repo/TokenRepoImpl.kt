package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.remote.TokenRemoteDataSource
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class TokenRepoImpl @Inject constructor(private val tokenRemoteDataSource: TokenRemoteDataSource):TokenRepo {
    override suspend fun getToken(loginRequest: LoginRequest): Response<LoginResponse> {
        return tokenRemoteDataSource.getToken(loginRequest)
    }
}