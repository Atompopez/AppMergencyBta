package com.example.appmergencybta.ui.typification

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmergencybta.R
import com.example.appmergencybta.data.database.entities.TypificationCode
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Fragmento para el aprendizaje de códigos mediante flashcards
 */
class FlashcardLearningFragment : Fragment() {

    private lateinit var viewModel: TypificationViewModel
    private lateinit var adapter: FlashcardGridAdapter
    
    private lateinit var etSearch: EditText
    private lateinit var rvFlashcards: RecyclerView
    private lateinit var btnSwitchMode: Button
    private lateinit var fabFlipAll: FloatingActionButton
    private lateinit var progressBar: ProgressBar
    private lateinit var tvNoResults: TextView
    
    private var currentCodes: List<TypificationCode> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_flashcard_learning, container, false)
        
        // Inicializar vistas
        etSearch = root.findViewById(R.id.etSearch)
        rvFlashcards = root.findViewById(R.id.rvFlashcards)
        btnSwitchMode = root.findViewById(R.id.btnSwitchMode)
        fabFlipAll = root.findViewById(R.id.fabFlipAll)
        progressBar = root.findViewById(R.id.progressBar)
        tvNoResults = root.findViewById(R.id.tvNoResults)
        
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Inicializar ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(TypificationViewModel::class.java)
        
        // Configurar RecyclerView con GridLayoutManager
        val spanCount = 2 // Número de columnas
        rvFlashcards.layoutManager = GridLayoutManager(requireContext(), spanCount)
        
        // Inicializar adaptador
        adapter = FlashcardGridAdapter(requireContext()) { code, isShowingFront ->
            // Manejar click en flashcard (opcional)
        }
        rvFlashcards.adapter = adapter
        
        // Configurar botón de cambio de modo
        btnSwitchMode.setOnClickListener {
            findNavController().navigate(R.id.action_flashcardLearningFragment_to_codePracticeFragment)
        }
        
        // Configurar botón flotante para voltear todas las tarjetas
        fabFlipAll.setOnClickListener {
            adapter.flipAllCards()
        }
        
        // Configurar búsqueda
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            
            override fun afterTextChanged(s: Editable?) {
                filterCodes(s.toString())
            }
        })
        
        // Observar cambios en los datos
        viewModel.codes.observe(viewLifecycleOwner) { codes ->
            currentCodes = codes
            updateFlashcards(codes)
        }
        
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        
        // Cargar los códigos
        viewModel.loadCodes()
    }
    
    /**
     * Filtra los códigos según el texto de búsqueda
     */
    private fun filterCodes(query: String) {
        if (query.isEmpty()) {
            updateFlashcards(currentCodes)
            return
        }
        
        val filteredCodes = currentCodes.filter { code ->
            code.code.contains(query, ignoreCase = true) || 
            code.acronym.contains(query, ignoreCase = true) ||
            code.description.contains(query, ignoreCase = true)
        }
        
        updateFlashcards(filteredCodes)
    }
    
    /**
     * Actualiza las flashcards en el RecyclerView
     */
    private fun updateFlashcards(codes: List<TypificationCode>) {
        if (codes.isEmpty()) {
            tvNoResults.visibility = View.VISIBLE
            rvFlashcards.visibility = View.GONE
        } else {
            tvNoResults.visibility = View.GONE
            rvFlashcards.visibility = View.VISIBLE
            adapter.setCodes(codes)
        }
    }
}
