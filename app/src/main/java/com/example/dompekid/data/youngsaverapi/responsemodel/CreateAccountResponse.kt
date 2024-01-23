package com.example.dompekid.data.youngsaverapi.responsemodel

import com.google.gson.annotations.SerializedName

data class CreateAccountResponse(

    @field:SerializedName("data")
    val data: DataCreateAccResponse? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("statusCode")
    val statusCode: Int? = null
)

data class DataCreateAccResponse(

    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("username")
    val username: String? = null

)