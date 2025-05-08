package com.example.appmergencybta.data

import android.content.Context
import android.content.SharedPreferences
import com.example.appmergencybta.data.model.ModuleProgress
import com.example.appmergencybta.data.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Clase que maneja las operaciones relacionadas con los usuarios
 */
class UserRepository(private val context: Context) {
    
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "user_data", Context.MODE_PRIVATE
    )
    private val gson = Gson()
    
    // Clave para almacenar la lista de usuarios
    private val USERS_KEY = "users_list"
    
    /**
     * Obtiene todos los usuarios registrados
     */
    fun getAllUsers(): List<User> {
        val usersJson = sharedPreferences.getString(USERS_KEY, null) ?: return emptyList()
        val type = object : TypeToken<List<User>>() {}.type
        return gson.fromJson(usersJson, type)
    }
    
    /**
     * Guarda un nuevo usuario o actualiza uno existente
     */
    fun saveUser(user: User) {
        val users = getAllUsers().toMutableList()
        val existingUserIndex = users.indexOfFirst { it.id == user.id }
        
        if (existingUserIndex >= 0) {
            users[existingUserIndex] = user
        } else {
            users.add(user)
        }
        
        val usersJson = gson.toJson(users)
        sharedPreferences.edit().putString(USERS_KEY, usersJson).apply()
    }
    
    /**
     * Obtiene un usuario por su ID
     */
    fun getUserById(userId: String): User? {
        return getAllUsers().find { it.id == userId }
    }
    
    /**
     * Obtiene un usuario por su número de documento
     */
    fun getUserByDocumentNumber(documentNumber: String): User? {
        return getAllUsers().find { it.documentNumber == documentNumber }
    }
    
    /**
     * Actualiza el estado activo/inactivo de un usuario
     */
    fun updateUserActiveStatus(userId: String, isActive: Boolean) {
        val user = getUserById(userId) ?: return
        val updatedUser = user.copy(isActive = isActive)
        saveUser(updatedUser)
    }
    
    /**
     * Actualiza el progreso de un usuario en un módulo específico
     */
    fun updateUserProgress(userId: String, moduleId: String, progress: ModuleProgress) {
        val user = getUserById(userId) ?: return
        val updatedProgress = user.progress.toMutableMap()
        updatedProgress[moduleId] = progress
        
        val updatedUser = user.copy(progress = updatedProgress)
        saveUser(updatedUser)
    }
    
    /**
     * Verifica las credenciales de un usuario para el inicio de sesión
     */
    fun login(documentNumber: String, password: String): Result<User> {
        // En una aplicación real, la contraseña debería estar encriptada
        // Para esta demo, asumimos que la contraseña es el mismo número de documento
        val user = getUserByDocumentNumber(documentNumber)
        
        return if (user != null && password == documentNumber && user.isActive) {
            Result.Success(user)
        } else if (user != null && !user.isActive) {
            Result.Error(Exception("Usuario inactivo. Contacte al administrador."))
        } else {
            Result.Error(Exception("Credenciales incorrectas."))
        }
    }
    
    /**
     * Registra un nuevo usuario
     */
    fun registerUser(displayName: String, documentNumber: String, entity: String, role: String): Result<User> {
        val existingUser = getUserByDocumentNumber(documentNumber)
        
        if (existingUser != null) {
            return Result.Error(Exception("Ya existe un usuario con este número de documento."))
        }
        
        val newUser = User(
            id = java.util.UUID.randomUUID().toString(),
            displayName = displayName,
            documentNumber = documentNumber,
            entity = entity,
            role = role
        )
        
        saveUser(newUser)
        return Result.Success(newUser)
    }
    
    /**
     * Obtiene los usuarios por rol
     */
    fun getUsersByRole(role: String): List<User> {
        return getAllUsers().filter { it.role == role }
    }
}
