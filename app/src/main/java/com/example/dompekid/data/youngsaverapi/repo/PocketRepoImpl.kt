package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSource
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpResponse
import retrofit2.Response
import javax.inject.Inject

class PocketRepoImpl @Inject constructor(private val dataSource: PocketRemoteDataSource):
    PocketRepo {
    override suspend fun getAllPocket(token:String): Response<PocketResponse> {
        return dataSource.getAllPocket(token)
    }

    override suspend fun postTopUp(
        authorization: String,
        topUpRequest: TopUpRequest
    ): Response<TopUpResponse> {
        return dataSource.postTopUp(authorization,topUpRequest)
    }
}