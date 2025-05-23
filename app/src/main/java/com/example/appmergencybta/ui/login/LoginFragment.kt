package com.example.appmergencybta.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.appmergencybta.databinding.FragmentLoginBinding
import android.content.Intent
import android.util.Log
import com.example.appmergencybta.MainActivity
import androidx.navigation.fragment.findNavController
import com.example.appmergencybta.R
import androidx.activity.OnBackPressedCallback

import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

   /* override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentLoginBinding.inflate(inflater, container, false)
      return binding.root

    }
*/
   override fun onCreateView(
       inflater: LayoutInflater,
       container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View? {
       _binding = FragmentLoginBinding.inflate(inflater, container, false)

       // ✅ Verificar si ya está logueado ANTES de mostrar la vista
       val sharedPref = activity?.getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
       val isLoggedIn = sharedPref?.getBoolean("isLoggedIn", false) ?: false
       if (isLoggedIn) {
           val intent = Intent(requireContext(), MainActivity::class.java)
           startActivity(intent)
           activity?.finish()
           return null //
       }

       return binding.root
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // No hacemos nada al presionar "Atrás"
                }
            }
        )
*/

        val sharedPref = requireActivity().getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
            return
        }
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.login
        //val loadingProgressBar = binding.loading

        loginViewModel.loginFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }
                loginButton.isEnabled = loginFormState.isDataValid
                loginFormState.usernameError?.let {
                    usernameEditText.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    passwordEditText.error = getString(it)
                }
            })

        loginViewModel.loginResult.observe(viewLifecycleOwner,
            Observer { loginResult ->
                loginResult ?: return@Observer
                //loadingProgressBar.visibility = View.GONE
                loginResult.error?.let {
                    showLoginFailed(it)
                }
                loginResult.success?.let {
                    updateUiWithUser(it)
                }
            })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                loginViewModel.loginDataChanged(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
        }
        usernameEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.addTextChangedListener(afterTextChangedListener)
        passwordEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(
                    usernameEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            }
            false
        }

        loginButton.setOnClickListener {
            //loadingProgressBar.visibility = View.VISIBLE
            loginViewModel.login(
                usernameEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }
    }

   /* private fun updateUiWithUser(model: LoggedInUserView) {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
*/
   private fun updateUiWithUser(model: LoggedInUserView) {
       Log.d("LoginFragment", "Login exitoso: ${model.displayName}")
       val sharedPref = requireActivity().getSharedPreferences("app_prefs", android.content.Context.MODE_PRIVATE)
       with(sharedPref.edit()) {
           putBoolean("isLoggedIn", true)
           putString("user_name", model.displayName)
           apply()
       }

       findNavController().navigate(R.id.inicioFragment)
   }


    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}