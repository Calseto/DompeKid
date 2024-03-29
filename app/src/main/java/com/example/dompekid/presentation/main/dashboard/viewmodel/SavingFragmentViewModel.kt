package com.example.dompekid.presentation.main.dashboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.mandiriapps.data.sharedpref.usecase.GetSharedPrefUseCase
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.usecase.GetAllPocketUseCase
import com.example.dompekid.data.youngsaverapi.usecase.GetSavingPocketOnly
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavingFragmentViewModel @Inject constructor(
    private val getSavingPocketUseCase: GetSavingPocketOnly,
    private val getSharedPrefUseCase: GetSharedPrefUseCase
):ViewModel(){

    private var listAll:List<PocketDataResponse?>?= listOf()
    private val _listPocketSaving = MutableLiveData<List<PocketDataResponse?>?>()
    val listPocketSaving: LiveData<List<PocketDataResponse?>?> get() = _listPocketSaving


    fun updateDataSaving(){
        viewModelScope.launch {
            val list = getSavingPocketUseCase.getSavingPocket(getSharedPrefUseCase.getSharedPref().getToken())
            if(list!=null) {
                listAll=list
                _listPocketSaving.postValue(list)
            }
            else
                println("data kosong")
        }
    }

    fun returnList(){
        _listPocketSaving.postValue(listAll)
    }
    fun filterData(string: String){
        val list = listAll?.filter {
            (it?.name?.contains(string, ignoreCase = true)==true)
        }
        _listPocketSaving.postValue(list)
    }
}