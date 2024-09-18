package com.example.finalassessment.app.ui.details


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalassessment.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val courseCode = intent.getStringExtra("COURSE_CODE") ?: ""
        val courseName = intent.getStringExtra("COURSE_NAME") ?: ""
        val credits = intent.getIntExtra("CREDITS", 0)
        val description = intent.getStringExtra("DESCRIPTION") ?: ""
        val instructor = intent.getStringExtra("INSTRUCTOR") ?: ""

        findViewById<TextView>(R.id.courseCode).text = "Course Code: $courseCode"
        findViewById<TextView>(R.id.courseName).text = "Course Name: $courseName"
        findViewById<TextView>(R.id.credits).text = "Credits: $credits"
        findViewById<TextView>(R.id.description).text = "Description: $description"
        findViewById<TextView>(R.id.instructor).text = "Instructor: $instructor"
    }
}