package com.example.dompekid.data.youngsaverapi.repo

import com.example.dompekid.data.youngsaverapi.remote.UserDataSource
import com.example.dompekid.data.youngsaverapi.responsemodel.TransferTargetResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import retrofit2.Response
import javax.inject.Inject

class UserDataRepoImpl @Inject constructor(private val dataSource: UserDataSource): UserDataRepo {
    override suspend fun getUserData(token:String): Response<UserRespons> {
        return dataSource.getUserData(token)
    }

    override suspend fun getTransferTargetData(rekID: String): Response<TransferTargetResponse> {
        return dataSource.getTransferTargetData(rekID)
    }
}