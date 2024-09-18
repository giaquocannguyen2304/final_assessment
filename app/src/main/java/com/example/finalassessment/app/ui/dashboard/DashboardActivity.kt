package com.example.finalassessment.app.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassessment.R
import com.example.finalassessment.app.ui.details.DetailsActivity
import com.example.finalassessment.model.ListOfEntities
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var adapter: EntityAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        setupRecyclerView()
        observeViewModel()

        // Fetch entities when the activity is created
        viewModel.fetchEntities()
    }

    private fun setupRecyclerView() {
        adapter = EntityAdapter(emptyList()) { entity ->
            navigateToDetailsActivity(entity)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.entities.observe(this) { entities ->
            adapter.updateEntities(entities)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(this) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun navigateToDetailsActivity(entity: ListOfEntities) {
        var intent = Intent(this, DetailsActivity::class.java).apply {
            intent.putExtra("ENTITY", entity)
        }
        startActivity(intent)
    }
}