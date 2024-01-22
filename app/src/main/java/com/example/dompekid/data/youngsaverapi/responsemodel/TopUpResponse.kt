package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class TopUpResponse(

	@field:SerializedName("data")
	val data: DataTopUpResponse? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class DataTopUpResponse(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("transfer_amount")
	val transferAmount: Any? = null,

	@field:SerializedName("id")
	val id: String? = null
)
