package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketResponse
import retrofit2.Response
import javax.inject.Inject

class CreateNewPocketUseCase @Inject constructor(private val repo:PocketRepo) {
    suspend fun createNewPocket(
        token:String,
        createPocketRequest: CreatePocketRequest
    ):Response<CreatePocketResponse>{
        return repo.createPocket(token,createPocketRequest)
    }
}