package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.remote.PocketRemoteDataSource
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import retrofit2.Response
import javax.inject.Inject

class PocketRepoImpl @Inject constructor(private val dataSource: PocketRemoteDataSource):
    PocketRepo {
    override suspend fun getAllPocket(token:String): Response<PocketResponse> {
        return dataSource.getAllPocket(token)
    }
}