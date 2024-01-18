package com.e.mandiriapps.data.sharedpref.local.impl

import android.content.SharedPreferences
import com.e.mandiriapps.data.sharedpref.local.SharedPrefDataSource
import com.example.dompekid.data.local.SharedPref
import javax.inject.Inject


class SharedPrefDataSourceImpl @Inject constructor (private val sharedPref: SharedPref) :
    SharedPrefDataSource {
    override fun getSharedPref(): SharedPref {
        return sharedPref
    }

}