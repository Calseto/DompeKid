package com.example.dompekid.presentation.landing.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.base.BaseViewModel
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import com.example.dompekid.data.youngsaverapi.usecase.GetSavingPocketOnly
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
):BaseViewModel(){

    private val _JWTToken = MutableLiveData<String?>()
    val JWTToken: LiveData<String?> get() = _JWTToken


    fun fetchToken(loginRequest: LoginRequest){
        viewModelScope.launch {
            _loadingState.postValue(true)
            val result =getTokenUseCase.getToken(loginRequest)
            if(result.body()?.statusCode==200) {
                _JWTToken.postValue(extractTokenFromResponse(result))
            }
            else{
                _JWTToken.postValue("gagal")
            }
        }
    }
    override fun resetLiveData(){
        _JWTToken.postValue(null)
        _loadingState.postValue(false)
    }
    private fun extractTokenFromResponse(response:Response<LoginResponse>):String?{
        val data = response.body()?.data
        if(data!=null)
            return "Bearer "+ data.token
        else
            return null
    }

    fun saveTokenToSharedPref(){
        val sharedPref=getSharedPrefUseCase.getSharedPref()
        sharedPref.saveToken(JWTToken.value)
    }
}