package com.example.dompekid.presentation.landing.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getTokenUseCase: GetTokenUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
): ViewModel(){
    private val _JWTToken = MutableLiveData<String?>()
    val JWTToken: LiveData<String?> get() = _JWTToken


    fun fetchToken(loginRequest: LoginRequest){
        viewModelScope.launch {
            _JWTToken.postValue(getTokenUseCase.getToken(loginRequest))
        }
    }
    fun saveTokenToSharedPref(){
        val sharedPref=getSharedPrefUseCase.getSharedPref()
        sharedPref.saveToken(JWTToken.value)
    }
}