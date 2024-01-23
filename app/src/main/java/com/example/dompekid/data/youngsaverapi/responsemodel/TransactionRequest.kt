package com.example.dompekid.data.youngsaverapi.responsemodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigInteger

@Parcelize
data class TransactionRequest(

	@field:SerializedName("idRekeningPenerima")
	val idRekeningPenerima: String? = null,

	@field:SerializedName("transferAmount")
	val transferAmount: BigInteger? = null,

	@field:SerializedName("idRekeningPengirim")
	val idRekeningPengirim: String? = null,

	@field:SerializedName("pocketId")
	val pocketId: String? = null
):Parcelable
