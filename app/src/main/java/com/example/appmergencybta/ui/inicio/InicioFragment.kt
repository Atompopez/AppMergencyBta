package com.example.appmergencybta.ui.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appmergencybta.databinding.FragmentInicioBinding
import android.content.Context
import androidx.navigation.fragment.findNavController
import com.example.appmergencybta.R

class InicioFragment : Fragment() {

    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener información del usuario
        val sharedPref = requireActivity().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val userName = sharedPref.getString("user_name", "") ?: ""
        val userRole = sharedPref.getString("user_role", "operador") ?: "operador"
        
        // Mostrar nombre del usuario y rol
        binding.tvWelcome.text = "Bienvenido(a), $userName"
        binding.tvRole.text = "Rol: ${if (userRole == "operador") "Operador" else "Supervisor"}"

        // Mostrar botón de gestión de usuarios solo para supervisores
        if (userRole == "supervisor") {
            binding.cardUsers.visibility = View.VISIBLE
        }

        // Configurar botones de navegación
        binding.btnModules.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_modulesFragment)
        }
        
        binding.btnProgress.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_progressFragment)
        }
        
        binding.btnUsers.setOnClickListener {
            findNavController().navigate(R.id.action_inicioFragment_to_usersFragment)
        }
        
        binding.btnLogout.setOnClickListener {
            with(sharedPref.edit()) {
                remove("isLoggedIn")
                remove("user_id")
                remove("user_name")
                apply()
            }

            findNavController().navigate(R.id.action_inicioFragment_to_roleSelectionFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
