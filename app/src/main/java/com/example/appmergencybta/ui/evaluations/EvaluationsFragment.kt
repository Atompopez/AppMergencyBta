package com.example.appmergencybta.ui.evaluations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmergencybta.databinding.FragmentEvaluationsBinding

class EvaluationsFragment : Fragment() {

    private var _binding: FragmentEvaluationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EvaluationsViewModel
    private lateinit var adapter: EvaluationsAdapter
    private val args: EvaluationsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEvaluationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, EvaluationsViewModelFactory(requireContext()))
            .get(EvaluationsViewModel::class.java)
        
        setupRecyclerView()
        
        // Cargar el módulo seleccionado y sus evaluaciones
        viewModel.loadModule(args.moduleId)
        
        // Observar los cambios en el módulo seleccionado
        viewModel.module.observe(viewLifecycleOwner) { module ->
            module?.let {
                binding.tvModuleTitle.text = it.title
                adapter.submitList(it.evaluations)
                
                // Mostrar mensaje si no hay evaluaciones disponibles
                if (it.evaluations.isEmpty()) {
                    binding.tvNoEvaluations.visibility = View.VISIBLE
                } else {
                    binding.tvNoEvaluations.visibility = View.GONE
                }
            }
        }
    }
    
    private fun setupRecyclerView() {
        adapter = EvaluationsAdapter { evaluationId ->
            // Navegar a la evaluación cuando se selecciona una
            val action = EvaluationsFragmentDirections.actionEvaluationsFragmentToEvaluationDetailFragment(
                args.moduleId, evaluationId
            )
            findNavController().navigate(action)
        }
        
        binding.recyclerEvaluations.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerEvaluations.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
