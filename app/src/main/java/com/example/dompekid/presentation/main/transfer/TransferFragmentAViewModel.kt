package com.example.dompekid.presentation.main.transfer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dompekid.base.BaseViewModel
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TransferTargetResponse
import com.example.dompekid.data.youngsaverapi.usecase.GetTransferDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransferFragmentAViewModel @Inject constructor(
    private val transferTargetUseCase: GetTransferDataUseCase
):BaseViewModel() {

    private val _targetTransfer = MutableLiveData<TransferTargetResponse?>()
    val targetTransfer: LiveData<TransferTargetResponse?> get() = _targetTransfer

    fun updateData(rekId: String){
        viewModelScope.launch {
            val data = transferTargetUseCase.getTransferTargetData(rekId)
            if (data.isSuccessful){
                _targetTransfer.postValue(data.body())
            }else{
                _targetTransfer.postValue(null)
            }
        }
    }

    override fun resetLiveData() {

    }
}