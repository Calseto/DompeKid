package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class RekeningResponse(

	@field:SerializedName("data")
	val data: DataRekening? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class DataRekening(

	@field:SerializedName("nomorRekening")
	val nomorRekening: String? = null,

	@field:SerializedName("balance")
	val balance: Any? = null,

	@field:SerializedName("idOwner")
	val idOwner: String? = null
)
