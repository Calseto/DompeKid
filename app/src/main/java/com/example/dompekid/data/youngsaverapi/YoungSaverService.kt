package com.example.dompekid.data.youngsaverapi

import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface YoungSaverService {

    @GET("pocket")
    suspend fun getAllPocket(@Header("Authorization") authorization: String): Response<PocketResponse>

    @POST("auth/login")
    suspend fun getJWTToken(@Body loginRequest: LoginRequest): Response<LoginResponse>
    @POST("auth/register")
    suspend fun makeAccount(@Body createAccountRequest: CreateAccountRequest): Response<CreateAccountResponse>
    @POST("child/register/{childUsername}")
    suspend fun register(@Header("Authorization") authorization: String?,@Body regisRequest:RegisRequest,@Path("childUsername")username:String?): Response<RegisResponse>
    @GET("child/mydata")
    suspend fun getUserData(@Header("Authorization") authorization: String): Response<UserRespons>

    @POST("topup")
    suspend fun postTopUp(@Header("Authorization") authorization: String,@Body topUpRequest: TopUpRequest): Response<TopUpResponse>


}