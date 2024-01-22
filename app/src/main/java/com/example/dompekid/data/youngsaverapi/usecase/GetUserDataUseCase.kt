package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.UserDataRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import retrofit2.Response
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(private val repo: UserDataRepo) {
    suspend fun getUserData(token:String):Response<UserRespons>{
        return repo.getUserData(token)
    }
}