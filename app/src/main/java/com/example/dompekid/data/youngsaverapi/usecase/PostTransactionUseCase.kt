package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class PostTransactionUseCase @Inject constructor(private val repo:PocketRepo) {
    suspend fun postTransaction(token:String,transactionRequest: TransactionRequest?):Response<TransactionResponse>{
        return repo.postTransaction(token,transactionRequest)
    }
}