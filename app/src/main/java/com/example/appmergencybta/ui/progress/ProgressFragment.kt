package com.example.appmergencybta.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmergencybta.databinding.FragmentProgressBinding

class ProgressFragment : Fragment() {

    private var _binding: FragmentProgressBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProgressViewModel
    private lateinit var adapter: ModuleProgressAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, ProgressViewModelFactory(requireContext()))
            .get(ProgressViewModel::class.java)
        
        setupRecyclerView()
        
        // Obtener el ID del usuario actual
        val sharedPref = requireActivity().getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
        val userId = sharedPref.getString("user_id", "") ?: ""
        
        if (userId.isNotEmpty()) {
            // Cargar el progreso del usuario
            viewModel.loadUserProgress(userId)
        }
        
        // Observar los cambios en el progreso del usuario
        viewModel.moduleProgressList.observe(viewLifecycleOwner) { progressList ->
            adapter.submitList(progressList)
            
            // Mostrar mensaje si no hay progreso
            if (progressList.isEmpty()) {
                binding.tvNoProgress.visibility = View.VISIBLE
            } else {
                binding.tvNoProgress.visibility = View.GONE
            }
            
            // Actualizar estadísticas generales
            val totalLessons = progressList.sumOf { it.completedLessons.size }
            val totalEvaluations = progressList.sumOf { it.completedEvaluations.size }
            val correctAnswers = progressList.sumOf { it.correctAnswers }
            val incorrectAnswers = progressList.sumOf { it.incorrectAnswers }
            val totalAnswers = correctAnswers + incorrectAnswers
            val accuracy = if (totalAnswers > 0) (correctAnswers.toFloat() / totalAnswers.toFloat()) * 100 else 0f
            
            binding.tvLessonsCompleted.text = "$totalLessons lecciones completadas"
            binding.tvEvaluationsCompleted.text = "$totalEvaluations evaluaciones completadas"
            binding.tvAccuracy.text = "Precisión: ${accuracy.toInt()}%"
        }
        
        // Observar los cambios en el usuario
        viewModel.user.observe(viewLifecycleOwner) { user ->
            user?.let {
                binding.tvUserName.text = it.displayName
                binding.tvUserEntity.text = it.entity
                binding.tvUserRole.text = "Rol: ${if (it.role == "operador") "Operador" else "Supervisor"}"
            }
        }
    }
    
    private fun setupRecyclerView() {
        adapter = ModuleProgressAdapter()
        
        binding.recyclerModuleProgress.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerModuleProgress.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
