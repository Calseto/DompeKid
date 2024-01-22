package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisResponse
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val service: YoungSaverService) : AuthRemoteDataSource{
    override suspend fun getToken(loginRequest: LoginRequest): Response<LoginResponse> {
        return service.getJWTToken(loginRequest)
    }

    override suspend fun createAccount(createAccountRequest: CreateAccountRequest): Response<CreateAccountResponse> {
        return service.makeAccount(createAccountRequest)
    }

    override suspend fun register(regisRequest: RegisRequest,username:String): Response<RegisResponse> {
        val parent=LoginRequest("rama123","12345678")
        val parentToken = "Bearer "+getToken(parent).body()?.data?.token
        return service.register(parentToken,regisRequest,username)
    }


}