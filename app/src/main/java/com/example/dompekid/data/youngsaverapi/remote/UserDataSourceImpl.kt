package com.example.dompekid.data.youngsaverapi.remote

import android.util.Log
import com.example.dompekid.data.youngsaverapi.YoungSaverService
import com.example.dompekid.data.youngsaverapi.responsemodel.TransferTargetResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import retrofit2.Response
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(private val service: YoungSaverService):UserDataSource{
    override suspend fun getUserData(token:String): Response<UserRespons> {
        return service.getUserData(token)
    }

    override suspend fun getTransferTargetData(rekID: String): Response<TransferTargetResponse> {
        Log.d("TAG", " Rek ID = " + rekID)
        return service.getTransferTarget(rekID)
    }
}