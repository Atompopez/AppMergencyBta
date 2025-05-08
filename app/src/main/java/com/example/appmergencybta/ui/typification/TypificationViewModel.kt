package com.example.appmergencybta.ui.typification

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.appmergencybta.data.TypificationRepository
import com.example.appmergencybta.data.database.entities.TypificationCode
import com.example.appmergencybta.data.database.entities.UserCodeProgress
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel para la funcionalidad de códigos de tipificación
 */
class TypificationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TypificationRepository(application)

    // LiveData para la lista de códigos
    private val _codes = MutableLiveData<List<TypificationCode>>()
    val codes: LiveData<List<TypificationCode>> = _codes

    // LiveData para el código seleccionado
    private val _selectedCode = MutableLiveData<TypificationCode>()
    val selectedCode: LiveData<TypificationCode> = _selectedCode

    // LiveData para el progreso del usuario
    private val _userProgress = MutableLiveData<List<UserCodeProgress>>()
    val userProgress: LiveData<List<UserCodeProgress>> = _userProgress

    // LiveData para la práctica actual
    private val _practiceQuestions = MutableLiveData<List<PracticeQuestion>>()
    val practiceQuestions: LiveData<List<PracticeQuestion>> = _practiceQuestions

    // LiveData para el índice de la pregunta actual
    private val _currentQuestionIndex = MutableLiveData<Int>()
    val currentQuestionIndex: LiveData<Int> = _currentQuestionIndex

    // LiveData para el resumen de la práctica
    private val _practiceSummary = MutableLiveData<PracticeSummary>()
    val practiceSummary: LiveData<PracticeSummary> = _practiceSummary

    // LiveData para el estado de carga
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Inicializar la base de datos con los códigos de tipificación
    init {
        loadCodes()
    }

    /**
     * Carga todos los códigos de tipificación
     */
    fun loadCodes() {
        viewModelScope.launch {
            _isLoading.value = true
            
            // Inicializar la base de datos si está vacía
            withContext(Dispatchers.IO) {
                repository.initializeDatabase()
            }
            
            // Observar los códigos de la base de datos
            repository.getAllCodes().collect { codesList ->
                _codes.value = codesList
                _isLoading.value = false
            }
        }
    }
    
    /**
     * Reinicia y carga los códigos de tipificación correctos de la guía oficial
     */
    fun resetAndLoadCodes() {
        viewModelScope.launch {
            _isLoading.value = true
            
            try {
                // Reiniciar la base de datos con los códigos correctos
                withContext(Dispatchers.IO) {
                    repository.resetAndInitializeDatabase()
                }
                
                // Cargar los códigos inmediatamente después de reiniciar
                val updatedCodes = withContext(Dispatchers.IO) {
                    repository.getCodesDirectly()
                }
                
                // Actualizar los códigos en el ViewModel
                _codes.value = updatedCodes
                
                // Luego configurar el observador para futuras actualizaciones
                repository.getAllCodes().collect { codesList ->
                    if (codesList != _codes.value) {
                        _codes.value = codesList
                    }
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                // En caso de error, asegurar que se desactiva el indicador de carga
                _isLoading.value = false
            }
        }
    }

    /**
     * Selecciona un código para ver sus detalles
     */
    fun selectCode(code: TypificationCode) {
        _selectedCode.value = code
    }

    /**
     * Carga el progreso del usuario
     */
    fun loadUserProgress() {
        viewModelScope.launch {
            val sharedPref = getApplication<Application>().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            val userId = sharedPref.getString("user_id", "") ?: ""
            
            if (userId.isNotEmpty()) {
                repository.getUserProgress(userId).collect { progress ->
                    _userProgress.value = progress
                }
            }
        }
    }

    /**
     * Genera preguntas para la práctica
     */
    fun generatePracticeQuestions(totalQuestions: Int = 10) {
        viewModelScope.launch {
            _isLoading.value = true
            
            val sharedPref = getApplication<Application>().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            val userId = sharedPref.getString("user_id", "") ?: ""
            
            // Obtener códigos para la práctica
            val practiceCodesList = if (userId.isNotEmpty()) {
                repository.getCodesForPractice(userId, totalQuestions)
            } else {
                repository.getRandomCodes(totalQuestions)
            }
            
            // Crear preguntas de práctica
            val questions = createPracticeQuestions(practiceCodesList)
            
            _practiceQuestions.value = questions
            _currentQuestionIndex.value = 0
            _isLoading.value = false
        }
    }

    /**
     * Crea preguntas de práctica a partir de los códigos
     */
    private fun createPracticeQuestions(codes: List<TypificationCode>): List<PracticeQuestion> {
        val allCodes = _codes.value ?: emptyList()
        if (allCodes.isEmpty() || codes.isEmpty()) return emptyList()
        
        return codes.map { code ->
            val questionType = (0..2).random() // 0: código->acrónimo, 1: acrónimo->código, 2: código->descripción
            
            when (questionType) {
                0 -> { // Mostrar código, adivinar acrónimo
                    val correctOption = code.acronym
                    val otherOptions = allCodes.filter { it.code != code.code }
                        .map { it.acronym }
                        .shuffled()
                        .take(3)
                    
                    val options = (otherOptions + correctOption).shuffled()
                    val correctIndex = options.indexOf(correctOption)
                    
                    PracticeQuestion(
                        code = code,
                        questionType = QuestionType.CODE_TO_ACRONYM,
                        options = options,
                        correctOptionIndex = correctIndex
                    )
                }
                1 -> { // Mostrar acrónimo, adivinar código
                    val correctOption = code.code
                    val otherOptions = allCodes.filter { it.code != code.code }
                        .map { it.code }
                        .shuffled()
                        .take(3)
                    
                    val options = (otherOptions + correctOption).shuffled()
                    val correctIndex = options.indexOf(correctOption)
                    
                    PracticeQuestion(
                        code = code,
                        questionType = QuestionType.ACRONYM_TO_CODE,
                        options = options,
                        correctOptionIndex = correctIndex
                    )
                }
                else -> { // Mostrar código, adivinar descripción
                    val correctOption = code.description.take(100) + if (code.description.length > 100) "..." else ""
                    val otherOptions = allCodes.filter { it.code != code.code }
                        .map { it.description.take(100) + if (it.description.length > 100) "..." else "" }
                        .shuffled()
                        .take(3)
                    
                    val options = (otherOptions + correctOption).shuffled()
                    val correctIndex = options.indexOf(correctOption)
                    
                    PracticeQuestion(
                        code = code,
                        questionType = QuestionType.CODE_TO_DESCRIPTION,
                        options = options,
                        correctOptionIndex = correctIndex
                    )
                }
            }
        }
    }

    /**
     * Avanza a la siguiente pregunta
     */
    fun nextQuestion() {
        val currentIndex = _currentQuestionIndex.value ?: 0
        val questions = _practiceQuestions.value ?: emptyList()
        
        if (currentIndex < questions.size - 1) {
            _currentQuestionIndex.value = currentIndex + 1
        } else {
            // Generar resumen de la práctica
            generatePracticeSummary()
        }
    }

    /**
     * Registra la respuesta del usuario
     */
    fun recordAnswer(isCorrect: Boolean) {
        viewModelScope.launch {
            val sharedPref = getApplication<Application>().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            val userId = sharedPref.getString("user_id", "") ?: ""
            
            if (userId.isNotEmpty()) {
                val currentQuestion = getCurrentQuestion()
                currentQuestion?.let {
                    repository.updateUserProgressAfterPractice(userId, it.code.code, isCorrect)
                }
            }
        }
    }

    /**
     * Obtiene la pregunta actual
     */
    fun getCurrentQuestion(): PracticeQuestion? {
        val questions = _practiceQuestions.value ?: return null
        val currentIndex = _currentQuestionIndex.value ?: 0
        
        return if (currentIndex < questions.size) {
            questions[currentIndex]
        } else {
            null
        }
    }

    /**
     * Genera el resumen de la práctica
     */
    private fun generatePracticeSummary() {
        val questions = _practiceQuestions.value ?: emptyList()
        val correctAnswers = questions.count { it.userAnswerCorrect == true }
        val wrongAnswers = questions.count { it.userAnswerCorrect == false }
        val unanswered = questions.size - correctAnswers - wrongAnswers
        
        val summary = PracticeSummary(
            totalQuestions = questions.size,
            correctAnswers = correctAnswers,
            wrongAnswers = wrongAnswers,
            unanswered = unanswered,
            accuracy = if (questions.isNotEmpty()) (correctAnswers.toFloat() / questions.size) * 100 else 0f
        )
        
        _practiceSummary.value = summary
    }

    /**
     * Actualiza si la respuesta del usuario es correcta
     */
    fun updateUserAnswer(isCorrect: Boolean) {
        val questions = _practiceQuestions.value?.toMutableList() ?: return
        val currentIndex = _currentQuestionIndex.value ?: return
        
        if (currentIndex < questions.size) {
            questions[currentIndex] = questions[currentIndex].copy(userAnswerCorrect = isCorrect)
            _practiceQuestions.value = questions
        }
    }
    
    /**
     * Limpia el resumen de la práctica anterior
     */
    fun clearPracticeSummary() {
        _practiceSummary.value = null
        _currentQuestionIndex.value = 0
    }
}

/**
 * Tipos de preguntas para la práctica
 */
enum class QuestionType {
    CODE_TO_ACRONYM,    // Mostrar código, adivinar acrónimo
    ACRONYM_TO_CODE,    // Mostrar acrónimo, adivinar código
    CODE_TO_DESCRIPTION // Mostrar código, adivinar descripción
}

/**
 * Clase que representa una pregunta de práctica
 */
data class PracticeQuestion(
    val code: TypificationCode,
    val questionType: QuestionType,
    val options: List<String>,
    val correctOptionIndex: Int,
    val userAnswerCorrect: Boolean? = null
)

/**
 * Clase que representa el resumen de una práctica
 */
data class PracticeSummary(
    val totalQuestions: Int,
    val correctAnswers: Int,
    val wrongAnswers: Int,
    val unanswered: Int,
    val accuracy: Float
)
