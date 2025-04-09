package com.example.appmergencybta.ui.roles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appmergencybta.R
import com.example.appmergencybta.databinding.FragmentRoleSelectionBinding

class RoleSelectionFragment : Fragment() {

    private var _binding: FragmentRoleSelectionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoleSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ⚠️ Solo para pruebas, para evitar que LoginFragment se redireccione automáticamente
        val sharedPref = requireActivity().getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
        sharedPref.edit().putBoolean("isLoggedIn", false).apply()

        binding.btnAgente.setOnClickListener {
            findNavController().navigate(R.id.action_roleSelectionFragment_to_loginFragment)
        }

        binding.btnSupervisor.setOnClickListener {
            findNavController().navigate(R.id.action_roleSelectionFragment_to_loginFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
