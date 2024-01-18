package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class TokenRemoteDataSourceImpl @Inject constructor(private val service: YoungSaverService) : TokenRemoteDataSource{
    override suspend fun getToken(loginRequest: LoginRequest): Response<LoginResponse> {
        return service.getJWTToken(loginRequest)
    }

}