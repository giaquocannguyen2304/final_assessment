package com.example.finalassessment.repository

import com.example.finalassessment.model.LoginRequest
import com.example.finalassessment.network.ApiService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val apiService: ApiService) {
     suspend fun login(username: String, password: String): Result<String> {
        return try {
            val response = apiService.login(LoginRequest(username, password))
            if (response.isSuccessful) {
                Result.success(response.body()?.keypass ?: "")
            } else {
                Result.failure(Exception("Login failed: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}