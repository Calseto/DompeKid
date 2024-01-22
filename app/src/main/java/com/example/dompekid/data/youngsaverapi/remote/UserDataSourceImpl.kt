package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import retrofit2.Response
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(private val service: YoungSaverService):UserDataSource{
    override suspend fun getUserData(token:String): Response<UserRespons> {
        return service.getUserData(token)
    }
}