package com.example.appmergencybta.ui.lessondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appmergencybta.databinding.FragmentLessonDetailBinding

class LessonDetailFragment : Fragment() {

    private var _binding: FragmentLessonDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LessonDetailViewModel
    private val args: LessonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLessonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, LessonDetailViewModelFactory(requireContext()))
            .get(LessonDetailViewModel::class.java)
        
        // Cargar la lección seleccionada
        viewModel.loadLesson(args.moduleId, args.lessonId)
        
        // Configurar el botón para marcar como completada
        binding.btnMarkAsCompleted.setOnClickListener {
            viewModel.markLessonAsCompleted(args.moduleId, args.lessonId)
            Toast.makeText(requireContext(), "Lección completada", Toast.LENGTH_SHORT).show()
            
            // Volver al detalle del módulo
            findNavController().navigateUp()
        }
        
        // Observar los cambios en la lección seleccionada
        viewModel.lesson.observe(viewLifecycleOwner) { lesson ->
            lesson?.let {
                binding.tvLessonTitle.text = it.title
                binding.tvLessonContent.text = it.content
                
                // Mostrar imagen si existe
                if (it.imageResource != null) {
                    binding.imgLesson.visibility = View.VISIBLE
                    binding.imgLesson.setImageResource(it.imageResource)
                } else {
                    binding.imgLesson.visibility = View.GONE
                }
                
                // Mostrar video si existe
                if (it.videoUrl != null) {
                    binding.videoContainer.visibility = View.VISIBLE
                    // Aquí se implementaría la reproducción del video
                } else {
                    binding.videoContainer.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
