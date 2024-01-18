package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class PocketResponse(

	@field:SerializedName("data")
	val data: List<PocketDataResponse?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class PocketDataResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("jenisPocket")
	val jenisPocket: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("saldo")
	val saldo: Any? = null,

	@field:SerializedName("target")
	val target: Any? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)
