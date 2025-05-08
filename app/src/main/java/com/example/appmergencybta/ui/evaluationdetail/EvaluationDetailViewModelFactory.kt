package com.example.appmergencybta.ui.evaluationdetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appmergencybta.data.ModuleRepository
import com.example.appmergencybta.data.UserRepository

/**
 * Factory para crear una instancia de EvaluationDetailViewModel con los repositorios necesarios
 */
class EvaluationDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EvaluationDetailViewModel::class.java)) {
            return EvaluationDetailViewModel(
                context = context,
                moduleRepository = ModuleRepository(),
                userRepository = UserRepository(context)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
