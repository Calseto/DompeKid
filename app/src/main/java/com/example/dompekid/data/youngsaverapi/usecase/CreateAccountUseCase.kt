package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.AuthRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountResponse
import retrofit2.Response
import javax.inject.Inject

class CreateAccountUseCase @Inject constructor(private val authRepo: AuthRepo) {
    suspend fun createAccount(createAccountRequest: CreateAccountRequest):Response<CreateAccountResponse>{
        return authRepo.createAccount(createAccountRequest)
    }
}