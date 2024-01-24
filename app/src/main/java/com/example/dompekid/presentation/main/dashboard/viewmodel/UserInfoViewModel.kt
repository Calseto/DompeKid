package com.example.dompekid.presentation.main.dashboard.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.base.BaseViewModel
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
):BaseViewModel(){

    private val _userData = MutableLiveData<UserRespons?>()
    val userData: LiveData<UserRespons?> get() = _userData


    private suspend fun fetchUserData(token: String){

        val userData = getUserDataUseCase.getUserData(token)
        if (userData.isSuccessful){
            _userData.postValue(userData.body())
        }else
        {
            Log.d("Error", "Data User Gagal Diambil")
        }
    }
    fun updateData(){
        viewModelScope.launch {
            _loadingState.postValue(true)
            val token = getSharedPrefUseCase.getSharedPref().getToken()
            fetchUserData(token)
        }
    }

    override fun resetLiveData() {
        _userData.postValue(null)
        _loadingState.postValue(null)
    }
}