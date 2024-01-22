package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class CreateAccountRequest(
	@field:SerializedName("username")
	val username: String? = null,
	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("role")
	val role: String? = "C"
)
