package com.example.dompekid.presentation.main.createpocket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.base.BaseViewModel
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import com.example.dompekid.data.youngsaverapi.usecase.CreateNewPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import com.example.dompekid.data.youngsaverapi.usecase.PostTopUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigInteger
import javax.inject.Inject

@HiltViewModel
class CreatePocketViewModel @Inject constructor(
    private val createNewPocketUseCase: CreateNewPocketUseCase,
    private val postTopUpUseCase: PostTopUpUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase

):BaseViewModel(){
    private val _createPocketResponse = MutableLiveData<CreatePocketResponse?>()
    val createPocketResponse: LiveData<CreatePocketResponse?> get() = _createPocketResponse

    fun updateData(createPocketRequest: CreatePocketRequest,nominal:BigInteger){
        viewModelScope.launch {
            val respose = createNewPocketUseCase.createNewPocket(
                getSharedPrefUseCase.getSharedPref().getToken(),
                createPocketRequest)
            if (respose.isSuccessful){
                val topUpRequest=TopUpRequest(nominal,respose.body()?.data?.id)
                postTopUpUseCase.postTopUp(getSharedPrefUseCase.getSharedPref().getToken(),topUpRequest)
                _createPocketResponse.postValue(respose.body())
            }
        }
    }

    override fun resetLiveData() {
        _createPocketResponse.postValue(null)
    }
}