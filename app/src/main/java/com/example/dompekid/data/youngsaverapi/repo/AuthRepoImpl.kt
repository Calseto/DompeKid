package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.remote.AuthRemoteDataSource
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisResponse
import retrofit2.Response
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(private val tokenRemoteDataSource: AuthRemoteDataSource):AuthRepo {
    override suspend fun getToken(loginRequest: LoginRequest): Response<LoginResponse> {
        return tokenRemoteDataSource.getToken(loginRequest)
    }

    override suspend fun createAccount(createAccountRequest: CreateAccountRequest): Response<CreateAccountResponse> {
        return tokenRemoteDataSource.createAccount(createAccountRequest)
    }

    override suspend fun register(regisRequest: RegisRequest,username:String): Response<RegisResponse> {
        return tokenRemoteDataSource.register(regisRequest,username)
    }

}