package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: TokenDataResponse? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class TokenDataResponse(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
