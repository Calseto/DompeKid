package com.example.dompekid.data.youngsaverapi.usecase

import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import javax.inject.Inject

class GetSavingPocketOnly @Inject constructor(private val useCase: GetAllPocketUseCase) {
    suspend fun getSavingPocket(token: String):List<PocketDataResponse?>?{
        val list = useCase.getALLPocket(token)
        return list?.filter {
            it?.jenisPocket=="Tabungan"
        }
    }
}