package com.example.dompekid.presentation.main.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetAllowancePocketOnly
import com.example.dompekid.data.youngsaverapi.usecase.GetSavingPocketOnly
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllowanceFragmentViewModel @Inject constructor(
    private val getAllowancePocketOnly: GetAllowancePocketOnly,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
):ViewModel(){

    private val _listPocketAllowance = MutableLiveData<List<PocketDataResponse?>?>()
    val listPocketAllowance: LiveData<List<PocketDataResponse?>?> get() = _listPocketAllowance


    fun updateDataAllowance(){
        viewModelScope.launch {
            val list = getAllowancePocketOnly.getAllowancePocket(getSharedPrefUseCase.getSharedPref().getToken())
            if(list!=null)
                _listPocketAllowance.postValue(list)
            else
                println("data kosong")
        }
    }
}