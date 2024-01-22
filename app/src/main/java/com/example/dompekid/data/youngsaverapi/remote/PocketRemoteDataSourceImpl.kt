package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpResponse
import retrofit2.Response
import javax.inject.Inject

class PocketRemoteDataSourceImpl @Inject constructor(
    private val service: YoungSaverService
) :
    PocketRemoteDataSource {
    override suspend fun getAllPocket(token:String): Response<PocketResponse> {
        return service.getAllPocket(token)
    }

    override suspend fun postTopUp(
        authorization: String,
        topUpRequest: TopUpRequest
    ): Response<TopUpResponse> {
       return service.postTopUp(authorization,topUpRequest)
    }
}