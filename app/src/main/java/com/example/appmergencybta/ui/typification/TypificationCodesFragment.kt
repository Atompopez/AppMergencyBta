package com.example.appmergencybta.ui.typification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.R
import com.example.appmergencybta.data.database.entities.TypificationCode

/**
 * Fragmento para mostrar la lista de códigos de tipificación
 */
class TypificationCodesFragment : Fragment() {

    private lateinit var viewModel: TypificationViewModel
    private lateinit var adapter: TypificationCodeAdapter
    
    private lateinit var rvTypificationCodes: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnStartPractice: Button
    private lateinit var btnFlashcardLearning: Button
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_typification_codes, container, false)
        
        // Inicializar vistas
        rvTypificationCodes = root.findViewById(R.id.rvTypificationCodes)
        progressBar = root.findViewById(R.id.progressBar)
        btnStartPractice = root.findViewById(R.id.btnStartPractice)
        btnFlashcardLearning = root.findViewById(R.id.btnFlashcardLearning)
        tvTitle = root.findViewById(R.id.tvTitle)
        tvDescription = root.findViewById(R.id.tvDescription)
        
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Inicializar ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(TypificationViewModel::class.java)
        
        // Configurar RecyclerView
        adapter = TypificationCodeAdapter(requireContext()) { code ->
            onCodeSelected(code)
        }
        
        rvTypificationCodes.layoutManager = LinearLayoutManager(requireContext())
        rvTypificationCodes.adapter = adapter
        
        // Observar cambios en los datos
        viewModel.codes.observe(viewLifecycleOwner) { codes ->
            adapter.setCodes(codes)
        }
        
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        
        // Configurar botones
        btnStartPractice.setOnClickListener {
            startPractice()
        }
        
        btnFlashcardLearning.setOnClickListener {
            startFlashcardLearning()
        }
        
        // Reiniciar y cargar los códigos correctos de la guía de tipificación
        viewModel.resetAndLoadCodes()
    }
    
    /**
     * Maneja la selección de un código
     */
    private fun onCodeSelected(code: TypificationCode) {
        viewModel.selectCode(code)
        findNavController().navigate(R.id.action_typificationCodesFragment_to_codeDetailFragment)
    }
    
    /**
     * Inicia la práctica de códigos
     */
    private fun startPractice() {
        viewModel.generatePracticeQuestions()
        findNavController().navigate(R.id.action_typificationCodesFragment_to_codePracticeFragment)
    }
    
    /**
     * Inicia el módulo de aprendizaje con flashcards
     */
    private fun startFlashcardLearning() {
        findNavController().navigate(R.id.action_typificationCodesFragment_to_flashcardLearningFragment)
    }
}
