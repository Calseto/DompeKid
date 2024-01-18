package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class LoginRequest(

	@field:SerializedName("username")
	val username: String,

	@field:SerializedName("password")
	val password: String
)
