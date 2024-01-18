package com.e.mandiriapps.data.sharedpref.repo.impl

import com.e.mandiriapps.data.sharedpref.local.SharedPrefDataSource
import com.e.mandiriapps.data.sharedpref.repo.SharedPrefRepo
import com.example.dompekid.data.local.SharedPref
import javax.inject.Inject

class SharedPrefRepoImpl @Inject constructor (private val sharedPrefDataSource: SharedPrefDataSource) : SharedPrefRepo {
    override fun getSharedPref(): SharedPref {
        return sharedPrefDataSource.getSharedPref()
    }


}