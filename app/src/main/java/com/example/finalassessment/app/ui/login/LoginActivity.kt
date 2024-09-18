package com.example.finalassessment.app.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.finalassessment.app.ui.dashboard.DashboardActivity
import com.example.finalassessment.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        setupUI()
        observeViewModel()
    }

    private fun setupUI() {
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (validateInput(username, password)) {
                viewModel.login(username, password)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.loginResult.observe(this) { result ->
            binding.progressBar.visibility = View.GONE
            binding.btnLogin.isEnabled = true

            result.onSuccess { keypass ->
                navigateToDashboard(keypass)
            }.onFailure { error ->
                showError(error.message ?: "An unknown error occurred")
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.btnLogin.isEnabled = !isLoading
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        if (username != "Gia Quoc An Nguyen") {
            showError("Please enter your first name")
            return false
        }
        if (password != "s8065036") {
            showError("Please enter a valid student ID (format: s12345678)")
            return false
        }
        return true
    }

    private fun showError(message: String) {
        binding.tvError.apply {
            text = message
            visibility = View.VISIBLE
        }
    }

    private fun navigateToDashboard(keypass: String) {
        val intent = Intent(this, DashboardActivity::class.java).apply {
            putExtra("KEYPASS", keypass)
        }
        startActivity(intent)
        finish() // This will close the LoginActivity so the user can't go back to it
    }
}