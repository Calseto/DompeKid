package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import retrofit2.Response

interface TokenRepo {
    suspend fun getToken(loginRequest: LoginRequest):Response<LoginResponse>
}