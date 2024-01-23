package com.example.dompekid.presentation.main.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor():ViewModel(){

    private val _btmNavPos = MutableLiveData(0)
    val btmNavPOs: LiveData<Int> get() = _btmNavPos

    fun updateBtmNavPos(pos:Int){
        viewModelScope.launch {
            _btmNavPos.postValue(pos)
        }
    }
}