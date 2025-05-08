package com.example.appmergencybta.data.model

/**
 * Clase de datos que representa a un usuario en el sistema
 */
data class User(
    val id: String,
    val displayName: String,
    val documentNumber: String,
    val entity: String,
    val role: String,
    val isActive: Boolean = true,
    val progress: Map<String, ModuleProgress> = mapOf()
)

/**
 * Clase de datos que representa el progreso de un usuario en un módulo específico
 */
data class ModuleProgress(
    val moduleId: String,
    val completedLessons: List<String> = listOf(),
    val correctAnswers: Int = 0,
    val incorrectAnswers: Int = 0,
    val completedEvaluations: List<String> = listOf(),
    val lastAccessDate: Long = System.currentTimeMillis()
)
