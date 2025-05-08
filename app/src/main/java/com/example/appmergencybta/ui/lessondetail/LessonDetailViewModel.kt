package com.example.appmergencybta.ui.lessondetail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmergencybta.data.ModuleRepository
import com.example.appmergencybta.data.UserRepository
import com.example.appmergencybta.data.model.Lesson
import com.example.appmergencybta.data.model.ModuleProgress

class LessonDetailViewModel(
    private val context: Context,
    private val moduleRepository: ModuleRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _lesson = MutableLiveData<Lesson>()
    val lesson: LiveData<Lesson> = _lesson

    /**
     * Carga una lección específica por su ID y el ID del módulo al que pertenece
     */
    fun loadLesson(moduleId: String, lessonId: String) {
        val module = moduleRepository.getModuleById(moduleId)
        val selectedLesson = module?.lessons?.find { it.id == lessonId }
        _lesson.value = selectedLesson
    }

    /**
     * Marca una lección como completada para el usuario actual
     */
    fun markLessonAsCompleted(moduleId: String, lessonId: String) {
        val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val userId = sharedPref.getString("user_id", "") ?: ""
        
        if (userId.isNotEmpty()) {
            val user = userRepository.getUserById(userId)
            user?.let {
                // Obtener o crear el progreso del módulo
                val moduleProgress = it.progress[moduleId] ?: ModuleProgress(moduleId)
                
                // Crear una nueva lista de lecciones completadas que incluya la lección actual
                val completedLessons = moduleProgress.completedLessons.toMutableList()
                if (!completedLessons.contains(lessonId)) {
                    completedLessons.add(lessonId)
                }
                
                // Crear un nuevo objeto de progreso con la lección marcada como completada
                val updatedProgress = moduleProgress.copy(
                    completedLessons = completedLessons,
                    lastAccessDate = System.currentTimeMillis()
                )
                
                // Actualizar el progreso del usuario
                userRepository.updateUserProgress(userId, moduleId, updatedProgress)
            }
        }
    }
}
