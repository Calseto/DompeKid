package com.example.dompekid.data.youngsaverapi.remote

import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import retrofit2.Response

interface UserDataSource {
    suspend fun getUserData(token:String):Response<UserRespons>
}