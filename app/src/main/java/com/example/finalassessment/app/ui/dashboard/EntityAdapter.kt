package com.example.finalassessment.app.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalassessment.R
import com.example.finalassessment.model.ListOfEntities

class EntityAdapter(
    private var entities: List<ListOfEntities>,
    private val onItemClick: (ListOfEntities) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseCodeTextView: TextView = itemView.findViewById(R.id.courseCode)
        val courseNameTextView: TextView = itemView.findViewById(R.id.courseName)
        val creditsTextView: TextView = itemView.findViewById(R.id.credits)
        val descriptionTextView: TextView = itemView.findViewById(R.id.description)
        val instructorTextView: TextView = itemView.findViewById(R.id.instructor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entities[position]
        holder.courseCodeTextView.text = "Course Code: ${entity.courseCode}"
        holder.courseNameTextView.text = "Course Name: ${entity.courseName}"
        holder.creditsTextView.text = "Credits: ${entity.credits}"
        holder.descriptionTextView.text = "Description: ${entity.description}"
        holder.instructorTextView.text = "Instructor: ${entity.instructor}"

        holder.itemView.setOnClickListener { onItemClick(entity) }
    }

    override fun getItemCount() = entities.size

    fun updateEntities(newEntities: List<ListOfEntities>) {
        entities = newEntities
        notifyDataSetChanged()
    }
}