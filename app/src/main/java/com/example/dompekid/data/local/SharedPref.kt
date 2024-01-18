package com.example.dompekid.data.local
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPref @Inject constructor(private val preferences: SharedPreferences) {

    fun saveToken(token: String?) {
        preferences.edit().putString(SHARED_PREF, token).apply()
    }

    fun getToken(): String {
        return preferences.getString(SHARED_PREF, "") ?: ""
    }

    fun deleteToken() {
        preferences.edit().putString(SHARED_PREF, "").apply()
    }

    companion object {
        private const val SHARED_PREF = "TOKEN_KEY"
    }
}