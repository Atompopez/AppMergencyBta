package com.example.appmergencybta.ui.register

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmergencybta.data.Result
import com.example.appmergencybta.data.UserRepository
import com.example.appmergencybta.data.model.User

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _registrationResult = MutableLiveData<RegistrationResult>()
    val registrationResult: LiveData<RegistrationResult> = _registrationResult

    /**
     * Registra un nuevo usuario en el sistema
     */
    fun registerUser(name: String, documentNumber: String, entity: String, role: String, password: String) {
        // En una aplicación real, la contraseña debería ser encriptada
        // Para esta demo, simplemente usamos el número de documento como contraseña
        val result = userRepository.registerUser(name, documentNumber, entity, role)
        
        when (result) {
            is Result.Success -> {
                _registrationResult.value = RegistrationResult(success = true)
            }
            is Result.Error -> {
                _registrationResult.value = RegistrationResult(error = result.exception.message)
            }
        }
    }
}

/**
 * Clase de datos que representa el resultado del registro
 */
data class RegistrationResult(
    val success: Boolean = false,
    val error: String? = null
)
