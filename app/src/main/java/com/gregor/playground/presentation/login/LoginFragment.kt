package com.gregor.playground.presentation.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gregor.playground.R
import com.gregor.playground.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            if (!validateLoginInput()) {
                return@setOnClickListener
            }
            viewModel.login(
                binding.userNameInput.text.toString(),
                binding.passwordInput.text.toString()
            )
                .observe(viewLifecycleOwner) { user ->
                    if (user.isError == true) {
                        onInvalidLogin()
                    } else {
                        Toast.makeText(context, "Hello ${user.data?.name}!", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                    }
                }
        }
    }

    private fun validateLoginInput() : Boolean {
        val result = binding.userNameInput.text.toString().isNotBlank()
                  && binding.passwordInput.text.toString().isNotBlank()
        if (!result) {
            onInvalidLogin()
        }
        return result
    }

    private fun onInvalidLogin() {
        Toast.makeText(context, R.string.login_input_invalid, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}