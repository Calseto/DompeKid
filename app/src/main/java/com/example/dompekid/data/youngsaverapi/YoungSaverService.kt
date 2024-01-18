package com.example.dompekid.data.youngsaverapi

import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface YoungSaverService {

    @GET("pocket")
    suspend fun getAllTransaction(@Header("Authorization") authorization: String): Response<PocketResponse>

    @POST("auth/login")
    suspend fun getJWTToken(@Body loginRequest: LoginRequest): Response<LoginResponse>
}