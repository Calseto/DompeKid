package com.example.dompekid.presentation.landing.register

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dompekid.base.BaseViewModel
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisResponse
import com.example.dompekid.data.youngsaverapi.usecase.CreateAccountUseCase
import com.example.dompekid.data.youngsaverapi.usecase.RequestRegistration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val requestRegistration: RequestRegistration,
    private val createAccountUseCase: CreateAccountUseCase
):BaseViewModel(){

    private val _status = MutableLiveData<Boolean?>()
    val status: LiveData<Boolean?> get() = _status

    fun register(regisRequest: RegisRequest,createAccountRequest: CreateAccountRequest){
        viewModelScope.launch {
            val response = createAccountUseCase.createAccount(createAccountRequest)
            val userName = response.body()?.data?.username
            if (response.isSuccessful && userName!=null) {
                val result = requestRegistration.requestRegis(regisRequest,userName)
                _loadingState.postValue(true)
                _status.postValue(extractStatusFromResponse(result))
                _loadingState.postValue(false)
            } else {
                Log.d("error", "gagal membuat akun")
            }


        }
    }
    override fun resetLiveData(){
        _status.postValue(null)
        _loadingState.postValue(false)
    }
    private fun extractStatusFromResponse(response:Response<RegisResponse>):Boolean{
        val data = response.body()?.statusCode
        return data == 200
    }

}