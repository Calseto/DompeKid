package com.e.mandiriapps.data.sharedpref.local

import com.example.dompekid.data.local.SharedPref

interface SharedPrefDataSource {
    fun getSharedPref(): SharedPref
}