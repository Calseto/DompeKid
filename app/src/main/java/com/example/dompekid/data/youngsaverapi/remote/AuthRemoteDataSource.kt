package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisResponse
import retrofit2.Response

interface AuthRemoteDataSource{
    suspend fun getToken(loginRequest: LoginRequest):Response<LoginResponse>
    suspend fun createAccount(createAccountRequest: CreateAccountRequest):Response<CreateAccountResponse>
    suspend fun register(regisRequest: RegisRequest,username:String):Response<RegisResponse>
}
