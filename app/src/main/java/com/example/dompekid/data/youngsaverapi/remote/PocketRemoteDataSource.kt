package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import retrofit2.Response

interface PocketRemoteDataSource {
    suspend fun getAllPocket(token:String): Response<PocketResponse>
}