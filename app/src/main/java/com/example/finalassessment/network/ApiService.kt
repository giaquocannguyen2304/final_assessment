package com.example.finalassessment.network

import com.example.finalassessment.model.LoginRequest
import com.example.finalassessment.model.LoginResponse
import com.example.finalassessment.model.DashboardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("footscray/auth")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getEntities(@Path("keypass") keypass: String): Response<DashboardResponse>
}
