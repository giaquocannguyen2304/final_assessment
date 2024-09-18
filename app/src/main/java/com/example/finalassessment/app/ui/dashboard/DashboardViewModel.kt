package com.example.finalassessment.app.ui.dashboard


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalassessment.model.ListOfEntities
import com.example.finalassessment.network.ApiService
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val _entities = MutableLiveData<List<ListOfEntities>>()
    val entities: LiveData<List<ListOfEntities>> = _entities

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun fetchEntities() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = ApiService.getEntities("Bearer $keypass")
                if (response.isSuccessful) {
                    _entities.value = response.body() ?: emptyList()
                } else {
                    _error.value = "Failed to fetch entities: ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "Network error: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    companion object {
        // This should be set after successful login
        var keypass: String = ""
    }
}