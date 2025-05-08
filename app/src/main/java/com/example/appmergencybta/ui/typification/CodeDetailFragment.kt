package com.example.appmergencybta.ui.typification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appmergencybta.R

/**
 * Fragmento para mostrar los detalles de un código de tipificación
 */
class CodeDetailFragment : Fragment() {

    private lateinit var viewModel: TypificationViewModel
    
    private lateinit var ivCodeIcon: ImageView
    private lateinit var tvCodeNumber: TextView
    private lateinit var tvCodeAcronym: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvQuestions: TextView
    private lateinit var tvCircumstances: TextView
    private lateinit var tvCircumstancesDesc: TextView
    private lateinit var tvTransfer: TextView
    private lateinit var tvCopy: TextView
    private lateinit var btnPractice: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_code_detail, container, false)
        
        // Inicializar vistas
        ivCodeIcon = root.findViewById(R.id.ivCodeIcon)
        tvCodeNumber = root.findViewById(R.id.tvCodeNumber)
        tvCodeAcronym = root.findViewById(R.id.tvCodeAcronym)
        tvDescription = root.findViewById(R.id.tvDescription)
        tvQuestions = root.findViewById(R.id.tvQuestions)
        tvCircumstances = root.findViewById(R.id.tvCircumstances)
        tvCircumstancesDesc = root.findViewById(R.id.tvCircumstancesDesc)
        tvTransfer = root.findViewById(R.id.tvTransfer)
        tvCopy = root.findViewById(R.id.tvCopy)
        btnPractice = root.findViewById(R.id.btnPractice)
        
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Inicializar ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(TypificationViewModel::class.java)
        
        // Observar el código seleccionado
        viewModel.selectedCode.observe(viewLifecycleOwner) { code ->
            if (code != null) {
                displayCodeDetails(code)
            }
        }
        
        // Configurar botón de práctica
        btnPractice.setOnClickListener {
            // Generar una práctica específica para este código
            viewModel.generatePracticeQuestions(1)
            findNavController().navigate(R.id.action_codeDetailFragment_to_codePracticeFragment)
        }
    }
    
    /**
     * Muestra los detalles del código seleccionado
     */
    private fun displayCodeDetails(code: com.example.appmergencybta.data.database.entities.TypificationCode) {
        // Establecer el icono
        val resourceId = getDrawableResourceId(code.imageResource)
        if (resourceId != 0) {
            ivCodeIcon.setImageResource(resourceId)
        } else {
            ivCodeIcon.setImageResource(R.drawable.ic_emergency)
        }
        
        // Establecer textos
        tvCodeNumber.text = getString(R.string.code_number, code.code)
        tvCodeAcronym.text = code.acronym
        tvDescription.text = code.description
        tvQuestions.text = code.questions
        
        // Circunstancias modificadoras
        if (!code.modifyingCircumstances.isNullOrEmpty()) {
            tvCircumstances.text = code.modifyingCircumstances
            tvCircumstances.visibility = View.VISIBLE
        } else {
            tvCircumstances.visibility = View.GONE
        }
        
        if (!code.modifyingCircumstancesDescription.isNullOrEmpty()) {
            tvCircumstancesDesc.text = code.modifyingCircumstancesDescription
            tvCircumstancesDesc.visibility = View.VISIBLE
        } else {
            tvCircumstancesDesc.visibility = View.GONE
        }
        
        // Transferencia de voz
        tvTransfer.text = code.voiceTransfer ?: "N/A"
        
        // Copia de incidente
        tvCopy.text = code.incidentCopy ?: "N/A"
    }
    
    /**
     * Obtiene el ID del recurso drawable a partir del nombre
     */
    private fun getDrawableResourceId(resourceName: String?): Int {
        if (resourceName.isNullOrEmpty()) return 0
        return resources.getIdentifier(resourceName, "drawable", requireContext().packageName)
    }
}
