package com.example.dompekid.presentation.main.editpocket

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.base.BaseViewModel
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.usecase.PostTopUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopUpPocketViewModel @Inject constructor(
    private val postTopUpUseCase: PostTopUpUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
):BaseViewModel() {
    private val _status = MutableLiveData<Boolean?>()
    val status: LiveData<Boolean?> get() = _status

    fun updateData(topUpRequest: TopUpRequest){
        viewModelScope.launch {
            val token = getSharedPrefUseCase.getSharedPref().getToken()
            val response = postTopUpUseCase.postTopUp(token,topUpRequest)
            if (response.isSuccessful) {
                _loadingState.postValue(true)
                _status.postValue(true)
                _loadingState.postValue(false)
            } else {
                Log.d("error", "gagal melakukan topup")
            }
        }
    }

    override fun resetLiveData() {
        _status.postValue(null)
    }
}