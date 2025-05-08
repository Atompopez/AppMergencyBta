package com.example.appmergencybta.ui.modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmergencybta.data.ModuleRepository
import com.example.appmergencybta.data.UserRepository
import com.example.appmergencybta.data.model.Module

class ModulesViewModel(
    private val moduleRepository: ModuleRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _modules = MutableLiveData<List<Module>>()
    val modules: LiveData<List<Module>> = _modules

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    /**
     * Carga los módulos disponibles para un rol específico
     */
    fun loadModulesForRole(role: String) {
        _loading.value = true
        
        // En una aplicación real, esto podría ser una operación asíncrona
        val availableModules = moduleRepository.getModulesForRole(role)
        _modules.value = availableModules
        
        _loading.value = false
    }

    /**
     * Obtiene un módulo por su ID
     */
    fun getModuleById(moduleId: String): Module? {
        return moduleRepository.getModuleById(moduleId)
    }
}
