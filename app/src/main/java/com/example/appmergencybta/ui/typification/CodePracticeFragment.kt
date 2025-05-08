package com.example.appmergencybta.ui.typification

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import com.google.android.material.button.MaterialButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.R

/**
 * Fragmento para la práctica de códigos de tipificación
 */
class CodePracticeFragment : Fragment() {

    private lateinit var viewModel: TypificationViewModel
    private lateinit var optionsAdapter: PracticeOptionAdapter
    
    private lateinit var tvProgress: TextView
    private lateinit var progressBarPractice: ProgressBar
    private lateinit var ivCodeImage: ImageView
    private lateinit var tvQuestionTitle: TextView
    private lateinit var tvQuestionContent: TextView
    private lateinit var rvOptions: RecyclerView
    private lateinit var btnNext: MaterialButton
    private lateinit var tvFeedback: TextView
    private lateinit var cardFeedback: CardView
    
    private var mediaPlayerCorrect: MediaPlayer? = null
    private var mediaPlayerWrong: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_code_practice, container, false)
        
        // Inicializar vistas
        tvProgress = root.findViewById(R.id.tvProgress)
        progressBarPractice = root.findViewById(R.id.progressBarPractice)
        ivCodeImage = root.findViewById(R.id.ivCodeImage)
        tvQuestionTitle = root.findViewById(R.id.tvQuestionTitle)
        tvQuestionContent = root.findViewById(R.id.tvQuestionContent)
        rvOptions = root.findViewById(R.id.rvOptions)
        btnNext = root.findViewById(R.id.btnNext)
        tvFeedback = root.findViewById(R.id.tvFeedback)
        cardFeedback = root.findViewById(R.id.cardFeedback)
        
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Inicializar ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(TypificationViewModel::class.java)
        
        // Inicializar MediaPlayers para sonidos
        initSounds()
        
        // Configurar RecyclerView
        optionsAdapter = PracticeOptionAdapter(requireContext()) { position ->
            onOptionSelected(position)
        }
        
        rvOptions.layoutManager = LinearLayoutManager(requireContext())
        rvOptions.adapter = optionsAdapter
        
        // Configurar botón de siguiente
        btnNext.setOnClickListener {
            viewModel.nextQuestion()
        }
        
        // Observar cambios en los datos
        viewModel.practiceQuestions.observe(viewLifecycleOwner) { questions ->
            updateProgress()
            loadCurrentQuestion()
        }
        
        viewModel.currentQuestionIndex.observe(viewLifecycleOwner) { index ->
            updateProgress()
            loadCurrentQuestion()
        }
        
        viewModel.practiceSummary.observe(viewLifecycleOwner) { summary ->
            // Si hay un resumen, navegar a la pantalla de resumen
            if (summary != null) {
                findNavController().navigate(R.id.action_codePracticeFragment_to_practiceSummaryFragment)
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        // Liberar recursos de MediaPlayer
        mediaPlayerCorrect?.release()
        mediaPlayerWrong?.release()
        mediaPlayerCorrect = null
        mediaPlayerWrong = null
    }
    
    /**
     * Inicializa los sonidos para las respuestas
     */
    private fun initSounds() {
        try {
            // Usar los archivos de audio que el usuario subió
            mediaPlayerCorrect = MediaPlayer.create(requireContext(), R.raw.rightansw)
            mediaPlayerWrong = MediaPlayer.create(requireContext(), R.raw.wrongansw)
        } catch (e: Exception) {
            // Manejar la excepción silenciosamente
        }
    }
    
    /**
     * Actualiza el progreso de la práctica
     */
    private fun updateProgress() {
        val questions = viewModel.practiceQuestions.value ?: return
        val currentIndex = viewModel.currentQuestionIndex.value ?: return
        
        tvProgress.text = getString(R.string.practice_progress, currentIndex + 1, questions.size)
        progressBarPractice.max = questions.size
        progressBarPractice.progress = currentIndex + 1
    }
    
    /**
     * Carga la pregunta actual
     */
    private fun loadCurrentQuestion() {
        val currentQuestion = viewModel.getCurrentQuestion() ?: return
        
        // Establecer el icono
        val resourceId = getDrawableResourceId(currentQuestion.code.imageResource)
        if (resourceId != 0) {
            ivCodeImage.setImageResource(resourceId)
        } else {
            ivCodeImage.setImageResource(R.drawable.ic_emergency)
        }
        
        // Configurar el título y contenido según el tipo de pregunta
        when (currentQuestion.questionType) {
            QuestionType.CODE_TO_ACRONYM -> {
                tvQuestionTitle.text = getString(R.string.select_acronym)
                tvQuestionContent.text = getString(R.string.code_number, currentQuestion.code.code)
            }
            QuestionType.ACRONYM_TO_CODE -> {
                tvQuestionTitle.text = getString(R.string.select_code)
                tvQuestionContent.text = getString(R.string.code_acronym, currentQuestion.code.acronym)
            }
            QuestionType.CODE_TO_DESCRIPTION -> {
                tvQuestionTitle.text = getString(R.string.select_description)
                tvQuestionContent.text = getString(R.string.code_number, currentQuestion.code.code)
            }
        }
        
        // Configurar las opciones
        optionsAdapter.setOptions(currentQuestion.options, currentQuestion.correctOptionIndex)
        
        // Ocultar feedback y botón de siguiente
        cardFeedback.visibility = View.GONE
        btnNext.visibility = View.GONE
    }
    
    /**
     * Maneja la selección de una opción
     */
    private fun onOptionSelected(position: Int) {
        val currentQuestion = viewModel.getCurrentQuestion() ?: return
        val isCorrect = position == currentQuestion.correctOptionIndex
        
        // Mostrar feedback
        tvFeedback.text = if (isCorrect) getString(R.string.correct_answer) else getString(R.string.wrong_answer)
        
        // Cambiar el color de fondo de la tarjeta según si es correcto o incorrecto
        cardFeedback.setCardBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                if (isCorrect) R.color.correct_option else R.color.incorrect_option
            )
        )
        
        // Mostrar la tarjeta de feedback
        cardFeedback.visibility = View.VISIBLE
        
        // Reproducir sonido solo si los MediaPlayers están disponibles
        if (isCorrect) {
            mediaPlayerCorrect?.let {
                if (it.isPlaying) it.stop()
                it.seekTo(0)
                it.start()
            }
        } else {
            mediaPlayerWrong?.let {
                if (it.isPlaying) it.stop()
                it.seekTo(0)
                it.start()
            }
        }
        
        // Mostrar respuestas correctas/incorrectas
        optionsAdapter.setShowFeedback(true)
        
        // Actualizar respuesta del usuario
        viewModel.updateUserAnswer(isCorrect)
        
        // Registrar respuesta en el progreso del usuario
        viewModel.recordAnswer(isCorrect)
        
        // Mostrar botón de siguiente
        btnNext.visibility = View.VISIBLE
    }
    
    /**
     * Obtiene el ID del recurso drawable a partir del nombre
     */
    private fun getDrawableResourceId(resourceName: String?): Int {
        if (resourceName.isNullOrEmpty()) return 0
        return resources.getIdentifier(resourceName, "drawable", requireContext().packageName)
    }
}
