package com.example.appmergencybta.ui.moduledetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.data.model.Lesson
import com.example.appmergencybta.databinding.ItemLessonBinding

/**
 * Adaptador para mostrar la lista de lecciones en un RecyclerView
 */
class LessonsAdapter(private val onLessonClick: (String) -> Unit) : 
    ListAdapter<Lesson, LessonsAdapter.LessonViewHolder>(LessonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val binding = ItemLessonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LessonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = getItem(position)
        holder.bind(lesson)
    }

    inner class LessonViewHolder(private val binding: ItemLessonBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(lesson: Lesson) {
            binding.tvLessonTitle.text = lesson.title
            binding.tvLessonNumber.text = "Lección ${lesson.order}"
            
            binding.root.setOnClickListener {
                onLessonClick(lesson.id)
            }
        }
    }
}

/**
 * Callback para comparar elementos en la lista y optimizar actualizaciones
 */
class LessonDiffCallback : DiffUtil.ItemCallback<Lesson>() {
    override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean {
        return oldItem == newItem
    }
}
