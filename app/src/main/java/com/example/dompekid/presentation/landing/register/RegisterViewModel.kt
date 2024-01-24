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

    private val _status = MutableLiveData<RegisResponse?>()
    val status: LiveData<RegisResponse?> get() = _status

    fun register(regisRequest: RegisRequest,createAccountRequest: CreateAccountRequest){
        viewModelScope.launch {
            _loadingState.postValue(true)
            val response = createAccountUseCase.createAccount(createAccountRequest)
            val userName = response.body()?.data?.username
            if (response.isSuccessful && userName!=null) {
                val result = requestRegistration.requestRegis(regisRequest,userName)
                _status.postValue(result.body())
            }
            else{
                _status.postValue(null)
            }


        }
    }
    override fun resetLiveData(){
        _status.postValue(null)
        _loadingState.postValue(false)
    }

}