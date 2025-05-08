package com.example.appmergencybta.data.database.dao

import androidx.room.*
import com.example.appmergencybta.data.database.entities.UserCodeProgress
import kotlinx.coroutines.flow.Flow

/**
 * DAO para acceder al progreso del usuario con los códigos de tipificación
 */
@Dao
interface UserCodeProgressDao {
    
    @Query("SELECT * FROM user_code_progress WHERE user_id = :userId")
    fun getUserProgress(userId: String): Flow<List<UserCodeProgress>>
    
    @Query("SELECT * FROM user_code_progress WHERE user_id = :userId AND code_id = :codeId")
    suspend fun getUserProgressForCode(userId: String, codeId: String): UserCodeProgress?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgress(progress: UserCodeProgress)
    
    @Update
    suspend fun updateProgress(progress: UserCodeProgress)
    
    @Delete
    suspend fun deleteProgress(progress: UserCodeProgress)
    
    @Query("DELETE FROM user_code_progress WHERE user_id = :userId")
    suspend fun deleteAllUserProgress(userId: String)
    
    @Query("SELECT * FROM user_code_progress WHERE user_id = :userId ORDER BY wrong_answers DESC, last_practice_date ASC LIMIT :limit")
    suspend fun getDifficultCodes(userId: String, limit: Int): List<UserCodeProgress>
    
    @Query("SELECT * FROM user_code_progress WHERE user_id = :userId ORDER BY difficulty_level DESC LIMIT :limit")
    suspend fun getHighDifficultyCodes(userId: String, limit: Int): List<UserCodeProgress>
    
    @Transaction
    @Query("SELECT * FROM user_code_progress WHERE user_id = :userId ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomUserProgress(userId: String, limit: Int): List<UserCodeProgress>
}
