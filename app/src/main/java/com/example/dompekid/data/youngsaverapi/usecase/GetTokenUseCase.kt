package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.AuthRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import retrofit2.Response
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(private val tokenRepo: AuthRepo){
    suspend fun getToken(loginRequest: LoginRequest):Response<LoginResponse>{
        return tokenRepo.getToken(loginRequest)
    }

}