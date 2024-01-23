package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.responsemodel.TransferTargetResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import retrofit2.Response

interface UserDataRepo {
    suspend fun getUserData(token:String):Response<UserRespons>
    suspend fun getTransferTargetData(rekID:String):Response<TransferTargetResponse>
}