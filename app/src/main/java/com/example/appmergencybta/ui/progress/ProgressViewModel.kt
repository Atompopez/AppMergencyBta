package com.example.appmergencybta.ui.progress

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmergencybta.data.ModuleRepository
import com.example.appmergencybta.data.UserRepository
import com.example.appmergencybta.data.model.ModuleProgress
import com.example.appmergencybta.data.model.User

class ProgressViewModel(
    private val moduleRepository: ModuleRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _moduleProgressList = MutableLiveData<List<ModuleProgressWithName>>()
    val moduleProgressList: LiveData<List<ModuleProgressWithName>> = _moduleProgressList

    /**
     * Carga el progreso del usuario por su ID
     */
    fun loadUserProgress(userId: String) {
        val user = userRepository.getUserById(userId)
        _user.value = user
        
        user?.let {
            val progressList = mutableListOf<ModuleProgressWithName>()
            
            // Para cada módulo en el progreso del usuario, obtener el nombre del módulo
            it.progress.forEach { (moduleId, progress) ->
                val module = moduleRepository.getModuleById(moduleId)
                module?.let { m ->
                    progressList.add(
                        ModuleProgressWithName(
                            moduleId = moduleId,
                            moduleName = m.title,
                            completedLessons = progress.completedLessons,
                            completedEvaluations = progress.completedEvaluations,
                            correctAnswers = progress.correctAnswers,
                            incorrectAnswers = progress.incorrectAnswers,
                            totalLessons = m.lessons.size,
                            totalEvaluations = m.evaluations.size
                        )
                    )
                }
            }
            
            _moduleProgressList.value = progressList
        }
    }
}

/**
 * Clase de datos que representa el progreso de un módulo con su nombre
 */
data class ModuleProgressWithName(
    val moduleId: String,
    val moduleName: String,
    val completedLessons: List<String>,
    val completedEvaluations: List<String>,
    val correctAnswers: Int,
    val incorrectAnswers: Int,
    val totalLessons: Int,
    val totalEvaluations: Int
)
