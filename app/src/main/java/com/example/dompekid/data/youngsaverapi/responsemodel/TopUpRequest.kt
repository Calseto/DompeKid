package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class TopUpRequest(

	@field:SerializedName("transfer_amount")
	val transferAmount: BigInteger? = null,

	@field:SerializedName("idPocket")
	val idPocket: String? = null
)
