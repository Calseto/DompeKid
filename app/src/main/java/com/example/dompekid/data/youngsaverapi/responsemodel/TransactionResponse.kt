package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class TransactionResponse(

	@field:SerializedName("data")
	val data: DataTransactionResponse? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

data class DataTransactionResponse(

	@field:SerializedName("sisaSaldoPenerima")
	val sisaSaldoPenerima: Any? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("sisaSaldoPengirim")
	val sisaSaldoPengirim: Any? = null,

	@field:SerializedName("idRekeningPenerima")
	val idRekeningPenerima: String? = null,

	@field:SerializedName("transferAmount")
	val transferAmount: Any? = null,

	@field:SerializedName("idRekeningPengirim")
	val idRekeningPengirim: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
