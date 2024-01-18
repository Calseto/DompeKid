package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import retrofit2.Response

interface TokenRemoteDataSource{
    suspend fun getToken(loginRequest: LoginRequest):Response<LoginResponse>
}
