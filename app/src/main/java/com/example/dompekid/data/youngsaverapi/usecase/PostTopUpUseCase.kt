package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpResponse
import retrofit2.Response
import javax.inject.Inject

class PostTopUpUseCase @Inject constructor(private val pocketRepo: PocketRepo) {
    suspend fun postTopUp(authorization:String,topUpRequest: TopUpRequest): Response<TopUpResponse> {
        return pocketRepo.postTopUp(authorization,topUpRequest)
    }
}