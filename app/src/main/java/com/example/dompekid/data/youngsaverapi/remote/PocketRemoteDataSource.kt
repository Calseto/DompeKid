package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpResponse
import retrofit2.Response

interface PocketRemoteDataSource {
    suspend fun getAllPocket(token:String): Response<PocketResponse>
    suspend fun postTopUp(authorization:String,topUpRequest: TopUpRequest):Response<TopUpResponse>
}