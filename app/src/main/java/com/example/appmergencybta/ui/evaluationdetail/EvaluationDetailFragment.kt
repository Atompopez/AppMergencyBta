package com.example.appmergencybta.ui.evaluationdetail

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appmergencybta.databinding.FragmentEvaluationDetailBinding
import com.example.appmergencybta.data.model.Question

class EvaluationDetailFragment : Fragment() {

    private var _binding: FragmentEvaluationDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EvaluationDetailViewModel
    private val args: EvaluationDetailFragmentArgs by navArgs()
    
    private var currentQuestionIndex = 0
    private var correctAnswers = 0
    private var selectedAnswerIndex = -1
    private var timer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEvaluationDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, EvaluationDetailViewModelFactory(requireContext()))
            .get(EvaluationDetailViewModel::class.java)
        
        // Cargar la evaluación seleccionada
        viewModel.loadEvaluation(args.moduleId, args.evaluationId)
        
        // Configurar los botones de navegación
        binding.btnNext.setOnClickListener {
            if (selectedAnswerIndex >= 0) {
                checkAnswer()
                moveToNextQuestion()
            } else {
                Toast.makeText(requireContext(), "Selecciona una respuesta", Toast.LENGTH_SHORT).show()
            }
        }
        
        // Observar los cambios en la evaluación seleccionada
        viewModel.evaluation.observe(viewLifecycleOwner) { evaluation ->
            evaluation?.let {
                binding.tvEvaluationTitle.text = it.title
                
                // Iniciar el temporizador si hay un límite de tiempo
                if (it.timeLimit != null) {
                    startTimer(it.timeLimit)
                    binding.timerLayout.visibility = View.VISIBLE
                } else {
                    binding.timerLayout.visibility = View.GONE
                }
                
                // Mostrar la primera pregunta
                if (it.questions.isNotEmpty()) {
                    showQuestion(it.questions[0])
                }
            }
        }
        
        // Configurar el grupo de radio buttons
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            selectedAnswerIndex = when (checkedId) {
                binding.radioOption1.id -> 0
                binding.radioOption2.id -> 1
                binding.radioOption3.id -> 2
                binding.radioOption4.id -> 3
                else -> -1
            }
        }
    }
    
    private fun showQuestion(question: Question) {
        // Limpiar selección anterior
        binding.radioGroup.clearCheck()
        selectedAnswerIndex = -1
        
        // Mostrar la pregunta actual
        binding.tvQuestionNumber.text = "Pregunta ${currentQuestionIndex + 1}/${viewModel.evaluation.value?.questions?.size ?: 0}"
        binding.tvQuestionText.text = question.text
        
        // Mostrar imagen si existe
        if (question.imageResource != null) {
            binding.imgQuestion.visibility = View.VISIBLE
            binding.imgQuestion.setImageResource(question.imageResource)
        } else {
            binding.imgQuestion.visibility = View.GONE
        }
        
        // Mostrar opciones
        if (question.options.size >= 1) binding.radioOption1.text = question.options[0]
        if (question.options.size >= 2) binding.radioOption2.text = question.options[1]
        if (question.options.size >= 3) binding.radioOption3.text = question.options[2]
        if (question.options.size >= 4) binding.radioOption4.text = question.options[3]
        
        // Mostrar u ocultar opciones según la cantidad disponible
        binding.radioOption1.visibility = if (question.options.size >= 1) View.VISIBLE else View.GONE
        binding.radioOption2.visibility = if (question.options.size >= 2) View.VISIBLE else View.GONE
        binding.radioOption3.visibility = if (question.options.size >= 3) View.VISIBLE else View.GONE
        binding.radioOption4.visibility = if (question.options.size >= 4) View.VISIBLE else View.GONE
        
        // Cambiar el texto del botón si es la última pregunta
        val isLastQuestion = currentQuestionIndex == (viewModel.evaluation.value?.questions?.size ?: 0) - 1
        binding.btnNext.text = if (isLastQuestion) "Finalizar" else "Siguiente"
    }
    
    private fun checkAnswer() {
        val currentQuestion = viewModel.evaluation.value?.questions?.get(currentQuestionIndex)
        currentQuestion?.let {
            if (selectedAnswerIndex == it.correctOptionIndex) {
                correctAnswers++
            }
        }
    }
    
    private fun moveToNextQuestion() {
        val evaluation = viewModel.evaluation.value ?: return
        
        currentQuestionIndex++
        
        if (currentQuestionIndex < evaluation.questions.size) {
            // Mostrar la siguiente pregunta
            showQuestion(evaluation.questions[currentQuestionIndex])
        } else {
            // Finalizar la evaluación
            finishEvaluation()
        }
    }
    
    private fun finishEvaluation() {
        timer?.cancel()
        
        val evaluation = viewModel.evaluation.value ?: return
        val totalQuestions = evaluation.questions.size
        val score = (correctAnswers.toFloat() / totalQuestions.toFloat()) * 100
        
        // Guardar el resultado de la evaluación
        viewModel.saveEvaluationResult(args.moduleId, args.evaluationId, score, correctAnswers, totalQuestions)
        
        // Mostrar el resultado
        binding.evaluationLayout.visibility = View.GONE
        binding.resultLayout.visibility = View.VISIBLE
        
        binding.tvScore.text = "${score.toInt()}%"
        binding.tvCorrectAnswers.text = "$correctAnswers de $totalQuestions respuestas correctas"
        
        // Determinar si aprobó o no
        val passed = score >= evaluation.passingScore
        binding.tvResult.text = if (passed) "¡Aprobado!" else "No aprobado"
        
        // Configurar el botón para volver
        binding.btnFinish.setOnClickListener {
            findNavController().navigateUp()
        }
    }
    
    private fun startTimer(minutes: Int) {
        val milliseconds = minutes * 60 * 1000L
        
        timer = object : CountDownTimer(milliseconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = (millisUntilFinished / 1000) % 60
                binding.tvTimer.text = String.format("%02d:%02d", minutes, seconds)
            }
            
            override fun onFinish() {
                Toast.makeText(requireContext(), "¡Tiempo agotado!", Toast.LENGTH_LONG).show()
                finishEvaluation()
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
        _binding = null
    }
}
