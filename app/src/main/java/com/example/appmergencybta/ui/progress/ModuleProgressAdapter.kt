package com.example.appmergencybta.ui.progress

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.databinding.ItemModuleProgressBinding

/**
 * Adaptador para mostrar el progreso de los módulos en un RecyclerView
 */
class ModuleProgressAdapter : 
    ListAdapter<ModuleProgressWithName, ModuleProgressAdapter.ModuleProgressViewHolder>(ModuleProgressDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleProgressViewHolder {
        val binding = ItemModuleProgressBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ModuleProgressViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleProgressViewHolder, position: Int) {
        val moduleProgress = getItem(position)
        holder.bind(moduleProgress)
    }

    inner class ModuleProgressViewHolder(private val binding: ItemModuleProgressBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(moduleProgress: ModuleProgressWithName) {
            binding.tvModuleName.text = moduleProgress.moduleName
            
            // Calcular porcentajes de progreso
            val lessonProgress = if (moduleProgress.totalLessons > 0) {
                (moduleProgress.completedLessons.size.toFloat() / moduleProgress.totalLessons.toFloat()) * 100
            } else 0f
            
            val evaluationProgress = if (moduleProgress.totalEvaluations > 0) {
                (moduleProgress.completedEvaluations.size.toFloat() / moduleProgress.totalEvaluations.toFloat()) * 100
            } else 0f
            
            val totalAnswers = moduleProgress.correctAnswers + moduleProgress.incorrectAnswers
            val accuracy = if (totalAnswers > 0) {
                (moduleProgress.correctAnswers.toFloat() / totalAnswers.toFloat()) * 100
            } else 0f
            
            // Mostrar estadísticas
            binding.tvLessonProgress.text = "Lecciones: ${moduleProgress.completedLessons.size}/${moduleProgress.totalLessons} (${lessonProgress.toInt()}%)"
            binding.tvEvaluationProgress.text = "Evaluaciones: ${moduleProgress.completedEvaluations.size}/${moduleProgress.totalEvaluations} (${evaluationProgress.toInt()}%)"
            binding.tvAccuracy.text = "Precisión: ${accuracy.toInt()}% (${moduleProgress.correctAnswers}/${totalAnswers})"
            
            // Actualizar barras de progreso
            binding.progressLessons.progress = lessonProgress.toInt()
            binding.progressEvaluations.progress = evaluationProgress.toInt()
            binding.progressAccuracy.progress = accuracy.toInt()
        }
    }
}

/**
 * Callback para comparar elementos en la lista y optimizar actualizaciones
 */
class ModuleProgressDiffCallback : DiffUtil.ItemCallback<ModuleProgressWithName>() {
    override fun areItemsTheSame(oldItem: ModuleProgressWithName, newItem: ModuleProgressWithName): Boolean {
        return oldItem.moduleId == newItem.moduleId
    }

    override fun areContentsTheSame(oldItem: ModuleProgressWithName, newItem: ModuleProgressWithName): Boolean {
        return oldItem == newItem
    }
}
