package com.example.appmergencybta.data

import android.content.Context
import com.example.appmergencybta.data.database.AppDatabase
import com.example.appmergencybta.data.database.entities.TypificationCode
import com.example.appmergencybta.data.database.entities.UserCodeProgress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

/**
 * Repositorio para manejar los códigos de tipificación y el progreso del usuario
 */
class TypificationRepository(private val context: Context) {
    
    private val typificationCodeDao = AppDatabase.getDatabase(context).typificationCodeDao()
    private val userCodeProgressDao = AppDatabase.getDatabase(context).userCodeProgressDao()
    
    // Métodos para códigos de tipificación
    fun getAllCodes(): Flow<List<TypificationCode>> = typificationCodeDao.getAllCodes()
    
    /**
     * Obtiene todos los códigos de tipificación directamente sin usar Flow
     * Útil para actualizaciones inmediatas de la UI
     */
    suspend fun getCodesDirectly(): List<TypificationCode> = typificationCodeDao.getCodesDirectly()
    
    suspend fun getCodeById(codeId: String): TypificationCode? = typificationCodeDao.getCodeById(codeId)
    
    suspend fun insertCode(code: TypificationCode) = typificationCodeDao.insertCode(code)
    
    suspend fun insertAllCodes(codes: List<TypificationCode>) = typificationCodeDao.insertAllCodes(codes)
    
    suspend fun updateCode(code: TypificationCode) = typificationCodeDao.updateCode(code)
    
    suspend fun deleteCode(code: TypificationCode) = typificationCodeDao.deleteCode(code)
    
    suspend fun deleteAllCodes() = typificationCodeDao.deleteAllCodes()
    
    suspend fun getRandomCodes(limit: Int): List<TypificationCode> = typificationCodeDao.getRandomCodes(limit)
    
    // Métodos para progreso del usuario
    fun getUserProgress(userId: String): Flow<List<UserCodeProgress>> = userCodeProgressDao.getUserProgress(userId)
    
    suspend fun getUserProgressForCode(userId: String, codeId: String): UserCodeProgress? = 
        userCodeProgressDao.getUserProgressForCode(userId, codeId)
    
    suspend fun insertProgress(progress: UserCodeProgress) = userCodeProgressDao.insertProgress(progress)
    
    suspend fun updateProgress(progress: UserCodeProgress) = userCodeProgressDao.updateProgress(progress)
    
    suspend fun deleteProgress(progress: UserCodeProgress) = userCodeProgressDao.deleteProgress(progress)
    
    suspend fun deleteAllUserProgress(userId: String) = userCodeProgressDao.deleteAllUserProgress(userId)
    
    suspend fun getDifficultCodes(userId: String, limit: Int): List<UserCodeProgress> = 
        userCodeProgressDao.getDifficultCodes(userId, limit)
    
    suspend fun getHighDifficultyCodes(userId: String, limit: Int): List<UserCodeProgress> = 
        userCodeProgressDao.getHighDifficultyCodes(userId, limit)
    
    suspend fun getRandomUserProgress(userId: String, limit: Int): List<UserCodeProgress> = 
        userCodeProgressDao.getRandomUserProgress(userId, limit)
    
    /**
     * Método para actualizar el progreso del usuario después de una práctica
     * @param userId ID del usuario
     * @param codeId ID del código de tipificación
     * @param isCorrect Si la respuesta fue correcta
     */
    suspend fun updateUserProgressAfterPractice(userId: String, codeId: String, isCorrect: Boolean) {
        val existingProgress = getUserProgressForCode(userId, codeId)
        
        if (existingProgress != null) {
            val updatedProgress = existingProgress.copy(
                attempts = existingProgress.attempts + 1,
                correctAnswers = if (isCorrect) existingProgress.correctAnswers + 1 else existingProgress.correctAnswers,
                wrongAnswers = if (!isCorrect) existingProgress.wrongAnswers + 1 else existingProgress.wrongAnswers,
                lastPracticeDate = System.currentTimeMillis(),
                difficultyLevel = calculateDifficultyLevel(existingProgress, isCorrect)
            )
            updateProgress(updatedProgress)
        } else {
            val newProgress = UserCodeProgress(
                userId = userId,
                codeId = codeId,
                attempts = 1,
                correctAnswers = if (isCorrect) 1 else 0,
                wrongAnswers = if (!isCorrect) 1 else 0,
                lastPracticeDate = System.currentTimeMillis(),
                difficultyLevel = if (isCorrect) 1 else 3
            )
            insertProgress(newProgress)
        }
    }
    
    /**
     * Calcula el nivel de dificultad basado en el historial de respuestas
     * El nivel de dificultad aumenta con respuestas incorrectas y disminuye con correctas
     */
    private fun calculateDifficultyLevel(progress: UserCodeProgress, isCorrect: Boolean): Int {
        val currentLevel = progress.difficultyLevel
        
        return when {
            isCorrect && currentLevel > 1 -> currentLevel - 1
            !isCorrect && currentLevel < 10 -> currentLevel + 1
            else -> currentLevel
        }
    }
    
    /**
     * Obtiene una lista de códigos para practicar, priorizando aquellos con mayor dificultad
     */
    suspend fun getCodesForPractice(userId: String, totalCodes: Int): List<TypificationCode> {
        // 60% códigos difíciles, 40% aleatorios
        val difficultCodesCount = (totalCodes * 0.6).toInt()
        val randomCodesCount = totalCodes - difficultCodesCount
        
        val difficultProgresses = getHighDifficultyCodes(userId, difficultCodesCount)
        val difficultCodeIds = difficultProgresses.map { it.codeId }
        
        val difficultCodes = difficultCodeIds.mapNotNull { getCodeById(it) }
        
        // Si no hay suficientes códigos difíciles, completamos con aleatorios
        val randomCodes = if (difficultCodes.size < difficultCodesCount) {
            val neededRandomCodes = totalCodes - difficultCodes.size
            getRandomCodes(neededRandomCodes)
        } else {
            getRandomCodes(randomCodesCount)
        }
        
        // Combinamos ambas listas evitando duplicados
        val combinedCodes = (difficultCodes + randomCodes).distinctBy { it.code }
        
        // Si aún no tenemos suficientes, obtenemos más aleatorios
        return if (combinedCodes.size < totalCodes) {
            val moreCodes = getRandomCodes(totalCodes - combinedCodes.size)
            (combinedCodes + moreCodes).distinctBy { it.code }.take(totalCodes)
        } else {
            combinedCodes.take(totalCodes)
        }
    }
    
    /**
     * Inicializa la base de datos con los códigos de tipificación si está vacía
     */
    suspend fun initializeDatabase() {
        val existingCodes = getAllCodes().first()
        if (existingCodes.isEmpty()) {
            val initialCodes = DataProvider.getTypificationCodes()
            insertAllCodes(initialCodes)
        }
    }
    
    /**
     * Reinicia la base de datos con los códigos de tipificación correctos
     * Este método se usa para actualizar los códigos cuando hay cambios en la guía de tipificación
     */
    suspend fun resetAndInitializeDatabase() {
        // Eliminar todos los códigos existentes
        deleteAllCodes()
        
        // Lista de códigos oficiales que deben mantenerse
        val officialCodes = setOf(
            "457", "535", "601", "602", "603", "604", "605", "606", "607", "608", 
            "609", "610", "611", "613", "615", "616", "617", "702", "703", "708", 
            "709", "715", "802", "901", "902", "903", "904", "905", "906", "909", 
            "910", "911", "912", "914", "915", "916", "918", "919", "922", "923", 
            "924", "926", "927", "928", "929", "930", "931", "932", "933", "934", 
            "935", "936", "937", "938", "941", "942", "943", "944", "946", "947", 
            "950", "951", "952", "953", "958", "961", "964", "965", "966", "967", 
            "968", "969", "972", "973", "974", "976", "977", "978", "982", "990", "992"
        )
        
        // Obtener todos los códigos y filtrar solo los oficiales
        val allCodes = DataProvider.getTypificationCodes()
        val filteredCodes = allCodes.filter { it.code in officialCodes }
        
        // Insertar solo los códigos oficiales
        insertAllCodes(filteredCodes)
    }
}
