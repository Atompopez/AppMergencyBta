package com.example.appmergencybta.ui.evaluations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmergencybta.data.ModuleRepository
import com.example.appmergencybta.data.UserRepository
import com.example.appmergencybta.data.model.Module

class EvaluationsViewModel(
    private val moduleRepository: ModuleRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _module = MutableLiveData<Module>()
    val module: LiveData<Module> = _module

    /**
     * Carga un módulo específico por su ID para mostrar sus evaluaciones
     */
    fun loadModule(moduleId: String) {
        val selectedModule = moduleRepository.getModuleById(moduleId)
        _module.value = selectedModule
    }
}
