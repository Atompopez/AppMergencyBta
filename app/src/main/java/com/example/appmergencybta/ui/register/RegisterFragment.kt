package com.example.appmergencybta.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appmergencybta.R
import com.example.appmergencybta.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, RegisterViewModelFactory(requireContext()))
            .get(RegisterViewModel::class.java)
        
        // Configurar el spinner de entidades
        val entities = arrayOf(
            "Centro de Comando C4",
            "Policía Nacional",
            "Bomberos",
            "Defensa Civil",
            "Secretaría de Salud",
            "Movilidad"
        )
        val entityAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, entities)
        entityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerEntity.adapter = entityAdapter
        
        // Configurar el botón de registro
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val documentNumber = binding.etDocument.text.toString()
            val entity = binding.spinnerEntity.selectedItem.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()
            
            // Validar que los campos no estén vacíos
            if (name.isEmpty() || documentNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(requireContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            // Validar que las contraseñas coincidan
            if (password != confirmPassword) {
                Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            // Obtener el rol de las preferencias compartidas
            val sharedPref = requireActivity().getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
            val role = sharedPref.getString("user_role", "operador") ?: "operador"
            
            // Registrar al usuario
            viewModel.registerUser(name, documentNumber, entity, role, password)
        }
        
        // Configurar el botón para volver al login
        binding.btnBackToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        
        // Observar el resultado del registro
        viewModel.registrationResult.observe(viewLifecycleOwner) { result ->
            result?.let {
                if (it.success) {
                    Toast.makeText(requireContext(), "Registro exitoso", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(requireContext(), it.error ?: "Error en el registro", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
