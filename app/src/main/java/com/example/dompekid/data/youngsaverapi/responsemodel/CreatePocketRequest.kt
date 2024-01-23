package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class CreatePocketRequest(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("jenisPocket")
	val jenisPocket: String? = null,

	@field:SerializedName("target")
	val target: Int? = null
)
