package com.example.appmergencybta.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

/**
 * Entidad que representa un código de tipificación para emergencias
 */
@Entity(tableName = "typification_codes")
data class TypificationCode(
    @PrimaryKey
    val code: String,
    
    @ColumnInfo(name = "acronym")
    val acronym: String,
    
    @ColumnInfo(name = "description")
    val description: String,
    
    @ColumnInfo(name = "questions")
    val questions: String,
    
    @ColumnInfo(name = "modifying_circumstances")
    val modifyingCircumstances: String?,
    
    @ColumnInfo(name = "modifying_circumstances_description")
    val modifyingCircumstancesDescription: String?,
    
    @ColumnInfo(name = "voice_transfer")
    val voiceTransfer: String?,
    
    @ColumnInfo(name = "incident_copy")
    val incidentCopy: String?,
    
    @ColumnInfo(name = "image_resource")
    val imageResource: String?
)
