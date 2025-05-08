package com.example.appmergencybta.ui.modules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmergencybta.R
import com.example.appmergencybta.databinding.FragmentModulesBinding

class ModulesFragment : Fragment() {

    private var _binding: FragmentModulesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ModulesViewModel
    private lateinit var adapter: ModulesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentModulesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, ModulesViewModelFactory(requireContext()))
            .get(ModulesViewModel::class.java)
        
        setupRecyclerView()
        observeViewModel()
        
        // Obtener el rol del usuario de las preferencias compartidas
        val sharedPref = requireActivity().getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
        val userRole = sharedPref.getString("user_role", "operador") ?: "operador"
        
        // Cargar los módulos disponibles para el rol del usuario
        viewModel.loadModulesForRole(userRole)
    }
    
    private fun setupRecyclerView() {
        adapter = ModulesAdapter { moduleId ->
            // Navegar al detalle del módulo cuando se selecciona uno
            val action = ModulesFragmentDirections.actionModulesFragmentToModuleDetailFragment(moduleId)
            findNavController().navigate(action)
        }
        
        binding.recyclerModules.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerModules.adapter = adapter
    }
    
    private fun observeViewModel() {
        viewModel.modules.observe(viewLifecycleOwner) { modules ->
            adapter.submitList(modules)
            
            // Mostrar mensaje si no hay módulos disponibles
            if (modules.isEmpty()) {
                binding.tvNoModules.visibility = View.VISIBLE
            } else {
                binding.tvNoModules.visibility = View.GONE
            }
        }
        
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
