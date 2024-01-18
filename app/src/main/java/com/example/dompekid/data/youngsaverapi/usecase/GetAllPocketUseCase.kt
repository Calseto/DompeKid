package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import javax.inject.Inject

class GetAllPocketUseCase @Inject constructor(private val repo: PocketRepo) {
    suspend fun getALLPocket(token:String):List<PocketDataResponse?>?{
        val response = repo.getAllPocket(token).body()
        return response?.data
    }
}