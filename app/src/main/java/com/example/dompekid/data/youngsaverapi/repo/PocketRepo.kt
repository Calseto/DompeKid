package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionResponse
import retrofit2.Response

interface PocketRepo {
    suspend fun createPocket(token: String,createPocketRequest: CreatePocketRequest):Response<CreatePocketResponse>
    suspend fun getAllPocket(token:String): Response<PocketResponse>
    suspend fun postTopUp(authorization:String,topUpRequest: TopUpRequest):Response<TopUpResponse>
    suspend fun postTransaction(authorization:String,transactionRequest: TransactionRequest?):Response<TransactionResponse>
}