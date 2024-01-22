package com.example.dompekid.presentation.main.dashboard.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getAllPocketUseCase: GetAllPocketUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
):ViewModel(){

    private val _userData = MutableLiveData<UserRespons?>()
    val userData: LiveData<UserRespons?> get() = _userData

    private val _listPocket = MutableLiveData<List<PocketDataResponse?>?>()
    val listPocket: LiveData<List<PocketDataResponse?>?> get() = _listPocket


    private suspend fun fetchAllPocketData(token:String){
        val list = getAllPocketUseCase.getALLPocket(token)
        if(list!=null)
            _listPocket.postValue(list)
        else
            println("data kosong")
    }
    private suspend fun fetchUserData(token: String){
        val userData = getUserDataUseCase.getUserData(token)
        if (userData.isSuccessful){
            _userData.postValue(userData.body())
        }else
        {
            Log.d("Error", "Data User Gagal Diambil")
        }
    }
    fun updateDataHome(){
        viewModelScope.launch {
            val token = getSharedPrefUseCase.getSharedPref().getToken()
            fetchUserData(token)
            fetchAllPocketData(token)
        }
    }
}