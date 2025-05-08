package com.example.appmergencybta.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmergencybta.data.UserRepository
import com.example.appmergencybta.data.model.User

class UsersViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    /**
     * Carga todos los usuarios registrados
     */
    fun loadUsers() {
        _loading.value = true
        
        // En una aplicación real, esto podría ser una operación asíncrona
        val allUsers = userRepository.getAllUsers()
        _users.value = allUsers
        
        _loading.value = false
    }

    /**
     * Cambia el estado activo/inactivo de un usuario
     */
    fun toggleUserActiveStatus(userId: String, isActive: Boolean) {
        userRepository.updateUserActiveStatus(userId, isActive)
        
        // Recargar la lista de usuarios para reflejar el cambio
        loadUsers()
    }
}
