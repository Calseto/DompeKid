package com.e.mandiriapps.data.sharedpref.usecase

import com.e.mandiriapps.data.sharedpref.repo.SharedPrefRepo
import com.example.dompekid.data.local.SharedPref
import javax.inject.Inject

class GetSharedPrefUseCase @Inject constructor(private val sharedPrefRepo: SharedPrefRepo)  {
     fun getSharedPref(): SharedPref {
        return sharedPrefRepo.getSharedPref()
    }
}