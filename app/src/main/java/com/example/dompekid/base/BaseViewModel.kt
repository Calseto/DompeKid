package com.example.dompekid.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

abstract class BaseViewModel:ViewModel() {
    protected val _loadingState = MutableLiveData<Boolean>(false)
    val loadingState: LiveData<Boolean> get() = _loadingState

    abstract fun resetLiveData()

    fun turnOffLoadingState(){
        _loadingState.postValue(false)
    }
}