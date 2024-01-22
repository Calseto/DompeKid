package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.repo.PocketRepo
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import javax.inject.Inject

class GetAllowancePocketOnly @Inject constructor(private val useCase: GetAllPocketUseCase) {
    suspend fun getAllowancePocket(token: String):List<PocketDataResponse?>?{
        val list = useCase.getALLPocket(token)
        return list?.filter {
            it?.jenisPocket=="UangSaku"
        }
    }
}