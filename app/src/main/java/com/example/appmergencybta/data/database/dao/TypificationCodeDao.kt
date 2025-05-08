package com.example.appmergencybta.data.database.dao

import androidx.room.*
import com.example.appmergencybta.data.database.entities.TypificationCode
import kotlinx.coroutines.flow.Flow

/**
 * DAO para acceder a los códigos de tipificación
 */
@Dao
interface TypificationCodeDao {
    
    @Query("SELECT * FROM typification_codes")
    fun getAllCodes(): Flow<List<TypificationCode>>
    
    @Query("SELECT * FROM typification_codes WHERE code = :codeId")
    suspend fun getCodeById(codeId: String): TypificationCode?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCode(code: TypificationCode)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCodes(codes: List<TypificationCode>)
    
    @Update
    suspend fun updateCode(code: TypificationCode)
    
    @Delete
    suspend fun deleteCode(code: TypificationCode)
    
    @Query("DELETE FROM typification_codes")
    suspend fun deleteAllCodes()
    
    @Query("SELECT * FROM typification_codes ORDER BY RANDOM() LIMIT :limit")
    suspend fun getRandomCodes(limit: Int): List<TypificationCode>
}
