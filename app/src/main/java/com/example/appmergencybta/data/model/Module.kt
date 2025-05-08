package com.example.appmergencybta.data.model

/**
 * Clase de datos que representa un módulo de formación
 */
data class Module(
    val id: String,
    val title: String,
    val description: String,
    val imageResource: Int,
    val lessons: List<Lesson>,
    val evaluations: List<Evaluation>,
    val requiredRoles: List<String> = listOf("operador", "supervisor") // Roles que pueden acceder a este módulo
)

/**
 * Clase de datos que representa una lección dentro de un módulo
 */
data class Lesson(
    val id: String,
    val title: String,
    val content: String,
    val imageResource: Int? = null,
    val videoUrl: String? = null,
    val order: Int
)

/**
 * Clase de datos que representa una evaluación
 */
data class Evaluation(
    val id: String,
    val title: String,
    val description: String,
    val questions: List<Question>,
    val passingScore: Int = 70, // Porcentaje mínimo para aprobar
    val timeLimit: Int? = null // Tiempo límite en minutos, null si no hay límite
)

/**
 * Clase de datos que representa una pregunta en una evaluación
 */
data class Question(
    val id: String,
    val text: String,
    val imageResource: Int? = null,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String? = null
)
