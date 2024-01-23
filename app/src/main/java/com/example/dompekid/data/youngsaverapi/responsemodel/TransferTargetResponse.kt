package com.example.dompekid.data.youngsaverapi.responsemodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class TransferTargetResponse(

	@field:SerializedName("data")
	val data: DataTransferTarget? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)

@Parcelize
data class DataTransferTarget(

	@field:SerializedName("nomorRekening")
	val nomorRekening: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
):Parcelable
