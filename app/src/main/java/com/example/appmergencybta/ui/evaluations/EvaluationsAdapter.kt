package com.example.appmergencybta.ui.evaluations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.data.model.Evaluation
import com.example.appmergencybta.databinding.ItemEvaluationBinding

/**
 * Adaptador para mostrar la lista de evaluaciones en un RecyclerView
 */
class EvaluationsAdapter(private val onEvaluationClick: (String) -> Unit) : 
    ListAdapter<Evaluation, EvaluationsAdapter.EvaluationViewHolder>(EvaluationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvaluationViewHolder {
        val binding = ItemEvaluationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EvaluationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EvaluationViewHolder, position: Int) {
        val evaluation = getItem(position)
        holder.bind(evaluation)
    }

    inner class EvaluationViewHolder(private val binding: ItemEvaluationBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(evaluation: Evaluation) {
            binding.tvEvaluationTitle.text = evaluation.title
            binding.tvEvaluationDescription.text = evaluation.description
            binding.tvQuestionCount.text = "${evaluation.questions.size} preguntas"
            
            if (evaluation.timeLimit != null) {
                binding.tvTimeLimit.text = "Tiempo límite: ${evaluation.timeLimit} minutos"
            } else {
                binding.tvTimeLimit.text = "Sin límite de tiempo"
            }
            
            binding.root.setOnClickListener {
                onEvaluationClick(evaluation.id)
            }
        }
    }
}

/**
 * Callback para comparar elementos en la lista y optimizar actualizaciones
 */
class EvaluationDiffCallback : DiffUtil.ItemCallback<Evaluation>() {
    override fun areItemsTheSame(oldItem: Evaluation, newItem: Evaluation): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Evaluation, newItem: Evaluation): Boolean {
        return oldItem == newItem
    }
}
