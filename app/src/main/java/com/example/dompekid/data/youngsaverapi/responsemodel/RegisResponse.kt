package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class RegisResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class Data(

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("nomorRekening")
	val nomorRekening: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("isBlocked")
	val isBlocked: Boolean? = null,

	@field:SerializedName("limitTransaksi")
	val limitTransaksi: Any? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("birthDate")
	val birthDate: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("userCredentialIds")
	val userCredentialIds: String? = null
)
