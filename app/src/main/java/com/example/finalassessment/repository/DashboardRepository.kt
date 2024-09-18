package com.example.finalassessment.repository

import com.example.finalassessment.model.ListOfEntities
import com.example.finalassessment.network.ApiService
import javax.inject.Inject

class DashboardRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getEntities(): Result<List<ListOfEntities>> {
        return try {
            val response = apiService.getEntities()
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception("Failed to fetch entities: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}