package com.example.appmergencybta.ui.typification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.appmergencybta.R

/**
 * Fragmento para mostrar el resumen de la práctica de códigos
 */
class PracticeSummaryFragment : Fragment() {

    private lateinit var viewModel: TypificationViewModel
    
    private lateinit var tvCorrectAnswers: TextView
    private lateinit var tvWrongAnswers: TextView
    private lateinit var tvAccuracy: TextView
    private lateinit var tvMessage: TextView
    private lateinit var btnPracticeAgain: Button
    private lateinit var btnBackToMenu: Button
    private lateinit var animationView: LottieAnimationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_practice_summary, container, false)
        
        // Inicializar vistas
        tvCorrectAnswers = root.findViewById(R.id.tvCorrectAnswers)
        tvWrongAnswers = root.findViewById(R.id.tvWrongAnswers)
        tvAccuracy = root.findViewById(R.id.tvAccuracy)
        tvMessage = root.findViewById(R.id.tvMessage)
        btnPracticeAgain = root.findViewById(R.id.btnPracticeAgain)
        btnBackToMenu = root.findViewById(R.id.btnBackToMenu)
        animationView = root.findViewById(R.id.animationView)
        
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Inicializar ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(TypificationViewModel::class.java)
        
        // Observar el resumen de la práctica
        viewModel.practiceSummary.observe(viewLifecycleOwner) { summary ->
            if (summary != null) {
                displaySummary(summary)
            }
        }
        
        // Configurar botones
        btnPracticeAgain.setOnClickListener {
            viewModel.generatePracticeQuestions()
            findNavController().navigate(R.id.action_practiceSummaryFragment_to_codePracticeFragment)
        }
        
        btnBackToMenu.setOnClickListener {
            findNavController().navigate(R.id.action_practiceSummaryFragment_to_typificationCodesFragment)
        }
    }
    
    /**
     * Muestra el resumen de la práctica
     */
    private fun displaySummary(summary: PracticeSummary) {
        tvCorrectAnswers.text = getString(R.string.correct_answers, summary.correctAnswers)
        tvWrongAnswers.text = getString(R.string.wrong_answers, summary.wrongAnswers)
        tvAccuracy.text = "Precisión: ${String.format("%.1f", summary.accuracy)}%"
        
        // Establecer mensaje según el rendimiento
        val message = when {
            summary.accuracy >= 90 -> "¡Excelente trabajo! Dominas estos códigos."
            summary.accuracy >= 70 -> "¡Buen trabajo! Sigue practicando para mejorar."
            summary.accuracy >= 50 -> "Vas por buen camino. Continúa practicando."
            else -> "Necesitas más práctica. ¡No te rindas!"
        }
        tvMessage.text = message
        
        // Establecer animación según el rendimiento
        try {
            val animationResId = when {
                summary.accuracy >= 70 -> R.raw.success_animation
                else -> R.raw.error_animation
            }
            animationView.setAnimation(animationResId)
            animationView.playAnimation()
        } catch (e: Exception) {
            // Manejar la excepción silenciosamente si no se encuentra la animación
            animationView.visibility = View.GONE
        }
    }
}
