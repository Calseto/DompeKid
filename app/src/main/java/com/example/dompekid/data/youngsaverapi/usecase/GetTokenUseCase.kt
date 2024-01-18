package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.TokenRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(private val tokenRepo: TokenRepo){
    suspend fun getToken(loginRequest: LoginRequest):String?{
        val body = tokenRepo.getToken(loginRequest).body()
        val data = body?.data
        if(data!=null)
            return "Bearer "+ data.token
        else
            return null
    }
}