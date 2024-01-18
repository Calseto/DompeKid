package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import retrofit2.Response

interface PocketRepo {
    suspend fun getAllPocket(token:String): Response<PocketResponse>
}