package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class PocketRemoteDataSourceImpl @Inject constructor(
    private val service: YoungSaverService
) : PocketRemoteDataSource
{
    override suspend fun createPocket(
        token: String,
        createPocketRequest: CreatePocketRequest
    ): Response<CreatePocketResponse> {
        return service.createPocket(token,createPocketRequest)
    }

    override suspend fun getAllPocket(token:String): Response<PocketResponse> {
        return service.getAllPocket(token)
    }

    override suspend fun postTopUp(
        authorization: String,
        topUpRequest: TopUpRequest
    ): Response<TopUpResponse> {
       return service.postTopUp(authorization,topUpRequest)
    }

    override suspend fun postTransaction(
        authorization: String,
        transactionRequest: TransactionRequest?
    ): Response<TransactionResponse> {
        val request=TransactionRequest(
            transactionRequest?.idRekeningPenerima,
            transactionRequest?.transferAmount,
            service.getRekeningSelf(authorization).body()?.data?.nomorRekening,
            transactionRequest?.pocketId)
        return  service.postTransaction(authorization,request)
    }
}