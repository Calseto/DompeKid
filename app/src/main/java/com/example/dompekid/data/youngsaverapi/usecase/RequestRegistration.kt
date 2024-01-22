package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.AuthRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisResponse
import retrofit2.Response
import javax.inject.Inject

class RequestRegistration @Inject constructor(private val tokenRepo: AuthRepo) {
    suspend fun requestRegis(regisRequest: RegisRequest,username:String): Response<RegisResponse> {
        return tokenRepo.register(regisRequest,username)
    }
}