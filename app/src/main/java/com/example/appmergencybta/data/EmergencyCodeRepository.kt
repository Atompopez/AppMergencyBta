package com.example.appmergencybta.data

import com.example.appmergencybta.R
import com.example.appmergencybta.data.model.Agency
import com.example.appmergencybta.data.model.CodeCategory
import com.example.appmergencybta.data.model.CodeSubcategory
import com.example.appmergencybta.data.model.EmergencyCode

/**
 * Clase que proporciona acceso a los códigos de emergencia
 */
class EmergencyCodeRepository {
    
    /**
     * Obtiene todas las categorías de códigos
     */
    fun getAllCategories(): List<CodeCategory> {
        return listOf(
            createSecurityCategory(),
            createMedicalCategory(),
            createFireCategory(),
            createTrafficCategory(),
            createDisasterCategory()
        )
    }
    
    /**
     * Obtiene todas las agencias
     */
    fun getAllAgencies(): List<Agency> {
        return listOf(
            Agency(
                id = "police",
                name = "Policía Nacional",
                description = "Encargada de mantener la seguridad y el orden público",
                imageResource = R.drawable.ic_menu_gallery, // Cambiar por imagen adecuada
                responsibleFor = listOf("security", "traffic")
            ),
            Agency(
                id = "medical",
                name = "Servicios Médicos",
                description = "Atención médica de emergencia",
                imageResource = R.drawable.ic_menu_gallery, // Cambiar por imagen adecuada
                responsibleFor = listOf("medical")
            ),
            Agency(
                id = "fire",
                name = "Bomberos",
                description = "Atención de incendios y rescates",
                imageResource = R.drawable.ic_menu_gallery, // Cambiar por imagen adecuada
                responsibleFor = listOf("fire", "disaster")
            ),
            Agency(
                id = "civil_defense",
                name = "Defensa Civil",
                description = "Atención de desastres y apoyo en emergencias",
                imageResource = R.drawable.ic_menu_gallery, // Cambiar por imagen adecuada
                responsibleFor = listOf("disaster")
            )
        )
    }
    
    /**
     * Obtiene todos los códigos de emergencia
     */
    fun getAllCodes(): List<EmergencyCode> {
        val allCodes = mutableListOf<EmergencyCode>()
        getAllCategories().forEach { category ->
            category.subcategories.forEach { subcategory ->
                allCodes.addAll(subcategory.codes)
            }
        }
        return allCodes
    }
    
    /**
     * Obtiene un código por su valor
     */
    fun getCodeByValue(codeValue: String): EmergencyCode? {
        return getAllCodes().find { it.code == codeValue }
    }
    
    /**
     * Crea la categoría de Seguridad
     */
    private fun createSecurityCategory(): CodeCategory {
        return CodeCategory(
            id = "security",
            name = "Seguridad",
            description = "Códigos relacionados con seguridad ciudadana y orden público",
            color = "#FF0000",
            subcategories = listOf(
                CodeSubcategory(
                    id = "theft",
                    name = "Hurto",
                    description = "Códigos relacionados con hurtos y robos",
                    codes = listOf(
                        EmergencyCode(
                            code = "602",
                            description = "Hurto a persona sin arma",
                            category = "security",
                            subcategory = "theft",
                            modifiers = listOf(),
                            agencies = listOf("police"),
                            priority = 3,
                            examples = listOf("Raponazo", "Cosquilleo", "Hurto de celular")
                        ),
                        EmergencyCode(
                            code = "603",
                            description = "Hurto a persona con arma",
                            category = "security",
                            subcategory = "theft",
                            modifiers = listOf("A", "H"),
                            agencies = listOf("police", "medical"),
                            priority = 2,
                            examples = listOf("Atraco con arma de fuego", "Atraco con arma blanca")
                        ),
                        EmergencyCode(
                            code = "604",
                            description = "Hurto a residencia",
                            category = "security",
                            subcategory = "theft",
                            modifiers = listOf("A", "H", "P"),
                            agencies = listOf("police"),
                            priority = 3,
                            examples = listOf("Robo a casa", "Robo a apartamento")
                        )
                    )
                ),
                CodeSubcategory(
                    id = "violence",
                    name = "Violencia",
                    description = "Códigos relacionados con actos violentos",
                    codes = listOf(
                        EmergencyCode(
                            code = "701",
                            description = "Riña",
                            category = "security",
                            subcategory = "violence",
                            modifiers = listOf("A", "H", "M"),
                            agencies = listOf("police", "medical"),
                            priority = 2,
                            examples = listOf("Pelea callejera", "Altercado en establecimiento")
                        ),
                        EmergencyCode(
                            code = "702",
                            description = "Violencia intrafamiliar",
                            category = "security",
                            subcategory = "violence",
                            modifiers = listOf("A", "H", "M"),
                            agencies = listOf("police", "medical"),
                            priority = 2,
                            examples = listOf("Maltrato a mujer", "Maltrato a menor")
                        )
                    )
                )
            )
        )
    }
    
    /**
     * Crea la categoría Médica
     */
    private fun createMedicalCategory(): CodeCategory {
        return CodeCategory(
            id = "medical",
            name = "Médica",
            description = "Códigos relacionados con emergencias médicas",
            color = "#00FF00",
            subcategories = listOf(
                CodeSubcategory(
                    id = "illness",
                    name = "Enfermedad",
                    description = "Códigos relacionados con enfermedades",
                    codes = listOf(
                        EmergencyCode(
                            code = "801",
                            description = "Enfermedad general",
                            category = "medical",
                            subcategory = "illness",
                            modifiers = listOf("C", "R"),
                            agencies = listOf("medical"),
                            priority = 3,
                            examples = listOf("Dolor abdominal", "Fiebre alta", "Dificultad respiratoria")
                        ),
                        EmergencyCode(
                            code = "802",
                            description = "Paro cardiorrespiratorio",
                            category = "medical",
                            subcategory = "illness",
                            modifiers = listOf(),
                            agencies = listOf("medical"),
                            priority = 1,
                            examples = listOf("Persona inconsciente sin pulso", "Paro cardíaco")
                        )
                    )
                ),
                CodeSubcategory(
                    id = "injury",
                    name = "Lesiones",
                    description = "Códigos relacionados con lesiones físicas",
                    codes = listOf(
                        EmergencyCode(
                            code = "803",
                            description = "Trauma",
                            category = "medical",
                            subcategory = "injury",
                            modifiers = listOf("C", "H"),
                            agencies = listOf("medical"),
                            priority = 2,
                            examples = listOf("Caída de altura", "Golpe fuerte", "Herida abierta")
                        )
                    )
                )
            )
        )
    }
    
    /**
     * Crea la categoría de Incendios
     */
    private fun createFireCategory(): CodeCategory {
        return CodeCategory(
            id = "fire",
            name = "Incendios",
            description = "Códigos relacionados con incendios y emergencias relacionadas",
            color = "#FFA500",
            subcategories = listOf(
                CodeSubcategory(
                    id = "structural",
                    name = "Estructural",
                    description = "Códigos relacionados con incendios en estructuras",
                    codes = listOf(
                        EmergencyCode(
                            code = "901",
                            description = "Incendio estructural",
                            category = "fire",
                            subcategory = "structural",
                            modifiers = listOf("H", "T"),
                            agencies = listOf("fire", "police", "medical"),
                            priority = 1,
                            examples = listOf("Incendio en vivienda", "Incendio en edificio")
                        )
                    )
                ),
                CodeSubcategory(
                    id = "vehicle",
                    name = "Vehicular",
                    description = "Códigos relacionados con incendios en vehículos",
                    codes = listOf(
                        EmergencyCode(
                            code = "902",
                            description = "Incendio vehicular",
                            category = "fire",
                            subcategory = "vehicle",
                            modifiers = listOf("H", "T"),
                            agencies = listOf("fire", "police", "medical"),
                            priority = 1,
                            examples = listOf("Vehículo en llamas", "Bus incendiado")
                        )
                    )
                )
            )
        )
    }
    
    /**
     * Crea la categoría de Tránsito
     */
    private fun createTrafficCategory(): CodeCategory {
        return CodeCategory(
            id = "traffic",
            name = "Tránsito",
            description = "Códigos relacionados con emergencias de tránsito",
            color = "#0000FF",
            subcategories = listOf(
                CodeSubcategory(
                    id = "accident",
                    name = "Accidentes",
                    description = "Códigos relacionados con accidentes de tránsito",
                    codes = listOf(
                        EmergencyCode(
                            code = "929",
                            description = "Accidente de tránsito",
                            category = "traffic",
                            subcategory = "accident",
                            modifiers = listOf("H", "M", "T"),
                            agencies = listOf("police", "medical", "fire"),
                            priority = 2,
                            examples = listOf("Choque entre vehículos", "Atropello")
                        )
                    )
                )
            )
        )
    }
    
    /**
     * Crea la categoría de Desastres
     */
    private fun createDisasterCategory(): CodeCategory {
        return CodeCategory(
            id = "disaster",
            name = "Desastres",
            description = "Códigos relacionados con desastres naturales y emergencias masivas",
            color = "#800080",
            subcategories = listOf(
                CodeSubcategory(
                    id = "natural",
                    name = "Naturales",
                    description = "Códigos relacionados con desastres naturales",
                    codes = listOf(
                        EmergencyCode(
                            code = "950",
                            description = "Inundación",
                            category = "disaster",
                            subcategory = "natural",
                            modifiers = listOf("H", "T"),
                            agencies = listOf("fire", "civil_defense", "police"),
                            priority = 2,
                            examples = listOf("Inundación por lluvia", "Desbordamiento de río")
                        ),
                        EmergencyCode(
                            code = "951",
                            description = "Deslizamiento",
                            category = "disaster",
                            subcategory = "natural",
                            modifiers = listOf("H", "T", "M"),
                            agencies = listOf("fire", "civil_defense", "police", "medical"),
                            priority = 1,
                            examples = listOf("Deslizamiento de tierra", "Avalancha")
                        )
                    )
                )
            )
        )
    }
}
