package com.example.appmergencybta.ui.moduledetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmergencybta.databinding.FragmentModuleDetailBinding

class ModuleDetailFragment : Fragment() {

    private var _binding: FragmentModuleDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ModuleDetailViewModel
    private lateinit var lessonsAdapter: LessonsAdapter
    private val args: ModuleDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModuleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, ModuleDetailViewModelFactory(requireContext()))
            .get(ModuleDetailViewModel::class.java)
        
        setupRecyclerView()
        
        // Cargar el módulo seleccionado
        viewModel.loadModule(args.moduleId)
        
        // Configurar el botón para ir a las evaluaciones
        binding.btnGoToEvaluations.setOnClickListener {
            val action = ModuleDetailFragmentDirections.actionModuleDetailFragmentToEvaluationsFragment(args.moduleId)
            findNavController().navigate(action)
        }
        
        // Observar los cambios en el módulo seleccionado
        viewModel.module.observe(viewLifecycleOwner) { module ->
            module?.let {
                binding.tvModuleTitle.text = it.title
                binding.tvModuleDescription.text = it.description
                binding.imgModule.setImageResource(it.imageResource)
                
                lessonsAdapter.submitList(it.lessons.sortedBy { lesson -> lesson.order })
            }
        }
    }
    
    private fun setupRecyclerView() {
        lessonsAdapter = LessonsAdapter { lessonId ->
            // Navegar al detalle de la lección cuando se selecciona una
            val action = ModuleDetailFragmentDirections.actionModuleDetailFragmentToLessonDetailFragment(
                args.moduleId, lessonId
            )
            findNavController().navigate(action)
        }
        
        binding.recyclerLessons.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerLessons.adapter = lessonsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
