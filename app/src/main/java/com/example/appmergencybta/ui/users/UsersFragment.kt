package com.example.appmergencybta.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmergencybta.databinding.FragmentUsersBinding

class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UsersViewModel
    private lateinit var adapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this, UsersViewModelFactory(requireContext()))
            .get(UsersViewModel::class.java)
        
        setupRecyclerView()
        
        // Verificar si el usuario actual es supervisor
        val sharedPref = requireActivity().getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
        val userRole = sharedPref.getString("user_role", "") ?: ""
        
        if (userRole != "supervisor") {
            // Si no es supervisor, mostrar mensaje y ocultar la lista de usuarios
            binding.tvNoAccess.visibility = View.VISIBLE
            binding.recyclerUsers.visibility = View.GONE
            binding.progressBar.visibility = View.GONE
        } else {
            // Si es supervisor, cargar la lista de usuarios
            loadUsers()
        }
    }
    
    private fun setupRecyclerView() {
        adapter = UsersAdapter { user, action ->
            when (action) {
                UsersAdapter.UserAction.TOGGLE_ACTIVE -> {
                    viewModel.toggleUserActiveStatus(user.id, !user.isActive)
                    val message = if (!user.isActive) "Usuario activado" else "Usuario desactivado"
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        
        binding.recyclerUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerUsers.adapter = adapter
    }
    
    private fun loadUsers() {
        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        
        viewModel.users.observe(viewLifecycleOwner) { users ->
            adapter.submitList(users)
            
            // Mostrar mensaje si no hay usuarios
            if (users.isEmpty()) {
                binding.tvNoUsers.visibility = View.VISIBLE
            } else {
                binding.tvNoUsers.visibility = View.GONE
            }
        }
        
        // Cargar la lista de usuarios
        viewModel.loadUsers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
