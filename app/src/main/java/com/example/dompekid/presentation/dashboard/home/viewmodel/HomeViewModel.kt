package com.example.dompekid.presentation.dashboard.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPocketUseCase: GetAllPocketUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
):ViewModel(){
    private val _listPocket = MutableLiveData<List<PocketDataResponse?>?>()
    val listPocket: LiveData<List<PocketDataResponse?>?> get() = _listPocket


    fun updateData(){
        viewModelScope.launch {
            val list = getAllPocketUseCase.getALLPocket(getSharedPrefUseCase.getSharedPref().getToken())
            if(list!=null)
                _listPocket.postValue(list)
            else
                println("data kosong")
        }
    }
}