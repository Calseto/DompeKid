package com.example.dompekid.data.youngsaverapi.responsemodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigInteger

data class PocketResponse(

	@field:SerializedName("data")
	val data: List<PocketDataResponse?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

@Parcelize
data class PocketDataResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("jenisPocket")
	val jenisPocket: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("saldo")
	val saldo: Long? = null,

	@field:SerializedName("target")
	val target: Long? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
):Parcelable
