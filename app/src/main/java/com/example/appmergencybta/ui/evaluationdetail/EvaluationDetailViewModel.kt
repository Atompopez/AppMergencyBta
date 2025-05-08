package com.example.appmergencybta.ui.evaluationdetail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmergencybta.data.ModuleRepository
import com.example.appmergencybta.data.UserRepository
import com.example.appmergencybta.data.model.Evaluation
import com.example.appmergencybta.data.model.ModuleProgress

class EvaluationDetailViewModel(
    private val context: Context,
    private val moduleRepository: ModuleRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _evaluation = MutableLiveData<Evaluation>()
    val evaluation: LiveData<Evaluation> = _evaluation

    /**
     * Carga una evaluación específica por su ID y el ID del módulo al que pertenece
     */
    fun loadEvaluation(moduleId: String, evaluationId: String) {
        val module = moduleRepository.getModuleById(moduleId)
        val selectedEvaluation = module?.evaluations?.find { it.id == evaluationId }
        _evaluation.value = selectedEvaluation
    }

    /**
     * Guarda el resultado de una evaluación para el usuario actual
     */
    fun saveEvaluationResult(moduleId: String, evaluationId: String, score: Float, correctAnswers: Int, totalQuestions: Int) {
        val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val userId = sharedPref.getString("user_id", "") ?: ""
        
        if (userId.isNotEmpty()) {
            val user = userRepository.getUserById(userId)
            user?.let {
                // Obtener o crear el progreso del módulo
                val moduleProgress = it.progress[moduleId] ?: ModuleProgress(moduleId)
                
                // Crear una nueva lista de evaluaciones completadas que incluya la evaluación actual
                val completedEvaluations = moduleProgress.completedEvaluations.toMutableList()
                if (!completedEvaluations.contains(evaluationId)) {
                    completedEvaluations.add(evaluationId)
                }
                
                // Actualizar el conteo de respuestas correctas e incorrectas
                val newCorrectAnswers = moduleProgress.correctAnswers + correctAnswers
                val newIncorrectAnswers = moduleProgress.incorrectAnswers + (totalQuestions - correctAnswers)
                
                // Crear un nuevo objeto de progreso con la evaluación marcada como completada
                val updatedProgress = moduleProgress.copy(
                    completedEvaluations = completedEvaluations,
                    correctAnswers = newCorrectAnswers,
                    incorrectAnswers = newIncorrectAnswers,
                    lastAccessDate = System.currentTimeMillis()
                )
                
                // Actualizar el progreso del usuario
                userRepository.updateUserProgress(userId, moduleId, updatedProgress)
            }
        }
    }
}
