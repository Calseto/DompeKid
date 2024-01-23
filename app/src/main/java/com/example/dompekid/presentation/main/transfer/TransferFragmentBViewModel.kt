package com.example.dompekid.presentation.main.transfer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.base.BaseViewModel
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TransferTargetResponse
import com.example.dompekid.data.youngsaverapi.usecase.PostTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransferFragmentBViewModel @Inject constructor(
    private val postTransactionUseCase: PostTransactionUseCase,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
) :BaseViewModel() {

    private val _transaction = MutableLiveData<TransactionResponse?>()
    val transaction: LiveData<TransactionResponse?> get() = _transaction

    fun updateData(transactionRequest: TransactionRequest?){
        viewModelScope.launch {
            val response = postTransactionUseCase.postTransaction(
                getSharedPrefUseCase.getSharedPref().getToken(),
                transactionRequest
            )
            if (response.isSuccessful){
                _transaction.postValue(response.body())
            }
            else{
                _transaction.postValue(null)
            }
        }
    }
    override fun resetLiveData() {

    }
}