package com.e.mandiriapps.data.sharedpref.repo

import com.example.dompekid.data.local.SharedPref

interface SharedPrefRepo {
    fun getSharedPref():SharedPref
}