package com.example.appmergencybta.data.model

/**
 * Clase de datos que representa un código de emergencia
 */
data class EmergencyCode(
    val code: String,
    val description: String,
    val category: String,
    val subcategory: String? = null,
    val modifiers: List<String> = listOf(),
    val agencies: List<String> = listOf(),
    val priority: Int, // 1-5, donde 1 es la más alta
    val examples: List<String> = listOf(),
    val imageResource: Int? = null
)

/**
 * Clase de datos que representa una categoría de códigos de emergencia
 */
data class CodeCategory(
    val id: String,
    val name: String,
    val description: String,
    val subcategories: List<CodeSubcategory> = listOf(),
    val color: String // Color para identificar visualmente la categoría
)

/**
 * Clase de datos que representa una subcategoría de códigos de emergencia
 */
data class CodeSubcategory(
    val id: String,
    val name: String,
    val description: String,
    val codes: List<EmergencyCode> = listOf()
)

/**
 * Clase de datos que representa una agencia que atiende emergencias
 */
data class Agency(
    val id: String,
    val name: String,
    val description: String,
    val imageResource: Int? = null,
    val responsibleFor: List<String> = listOf() // Lista de categorías de códigos que atiende
)
