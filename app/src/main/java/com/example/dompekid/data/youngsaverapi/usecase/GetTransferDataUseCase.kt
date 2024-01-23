package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.UserDataRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.TransferTargetResponse
import retrofit2.Response
import javax.inject.Inject

class GetTransferDataUseCase @Inject constructor(private val repo:UserDataRepo) {
    suspend fun getTransferTargetData(rekId:String):Response<TransferTargetResponse>{
        return repo.getTransferTargetData(rekId)
    }
}