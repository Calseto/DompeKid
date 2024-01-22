package com.example.dompekid.data.youngsaverapi.responsemodel

import android.icu.text.SimpleDateFormat
import java.lang.reflect.Type
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.deser.std.DateDeserializers
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.text.ParseException
import java.time.LocalDate
import java.util.Date

data class RegisRequest(

	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("phoneNumber")
	val phoneNumber: String? = null,

	@SerializedName("birthDate")
	val birthDate: String? = null,

	@field:SerializedName("email")
	val email: String? = "example@gmail.com"
)


