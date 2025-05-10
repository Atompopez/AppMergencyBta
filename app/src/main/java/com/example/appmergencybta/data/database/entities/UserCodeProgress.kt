package com.example.appmergencybta.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.ForeignKey

/**
 * Entidad que representa el progreso de un usuario en un código de tipificación específico
 */
@Entity(
    tableName = "user_code_progress",
    foreignKeys = [
        ForeignKey(
            entity = TypificationCode::class,
            parentColumns = ["code"],
            childColumns = ["code_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        androidx.room.Index(value = ["code_id"]) // Add index for foreign key
    ]
)
data class UserCodeProgress(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "user_id")
    val userId: String,
    
    @ColumnInfo(name = "code_id")
    val codeId: String,
    
    @ColumnInfo(name = "attempts")
    val attempts: Int = 0,
    
    @ColumnInfo(name = "correct_answers")
    val correctAnswers: Int = 0,
    
    @ColumnInfo(name = "wrong_answers")
    val wrongAnswers: Int = 0,
    
    @ColumnInfo(name = "last_practice_date")
    val lastPracticeDate: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "difficulty_level")
    val difficultyLevel: Int = 1 // 1-10, donde 10 es máxima dificultad
)
