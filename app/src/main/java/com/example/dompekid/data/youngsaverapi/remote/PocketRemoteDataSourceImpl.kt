package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import retrofit2.Response
import javax.inject.Inject

class PocketRemoteDataSourceImpl @Inject constructor(
    private val service: YoungSaverService,
    private val getTokenUseCase: GetTokenUseCase
) :
    PocketRemoteDataSource {
    override suspend fun getAllPocket(token:String): Response<PocketResponse> {
        return service.getAllTransaction(token)
    }
}