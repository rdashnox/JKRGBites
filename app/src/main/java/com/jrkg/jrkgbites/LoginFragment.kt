package com.jrkg.jrkgbites

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.jrkg.jrkgbites.utils.ValidationUtils

class LoginFragment : Fragment(R.layout.fragment_login) {



    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var checkBoxKeepMeLoggedIn: CheckBox
    private lateinit var loginButton: Button

    private lateinit var bioAuthButton: Button
    private lateinit var goToForgotPassword: TextView
    private lateinit var gotoRegister: TextView


    private var isValidEmailFormat: Boolean = false
    private var isAutoLoginEnabled: Boolean = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        etEmail = view.findViewById(R.id.etEmail)
        etPassword = view.findViewById(R.id.etPassword)
        checkBoxKeepMeLoggedIn = view.findViewById(R.id.checkboxKeepMeLoggedIn)
        loginButton = view.findViewById(R.id.btnLogin)
        bioAuthButton = view.findViewById(R.id.btnBioAuth)
        goToForgotPassword = view.findViewById(R.id.txtForgotPassword)
        gotoRegister = view.findViewById(R.id.txtGotoRegister)


        setupListeners()
    }

    private fun setupListeners() {

        etEmail.addTextChangedListener {
            if (!ValidationUtils.validateEmailFormat(etEmail)) {
                isValidEmailFormat = false;
            }
            else {
                isValidEmailFormat = true;
            }
        }

        etPassword.addTextChangedListener {
        }

        checkBoxKeepMeLoggedIn.setOnCheckedChangeListener{ _, isChecked ->
            updateAutoLoginStatus(isChecked)
        }

        loginButton.setOnClickListener {
            onLoginButtonPressed()
        }

        bioAuthButton.setOnClickListener {
            onBioAuthButtonPressed()
        }

        goToForgotPassword.setOnClickListener {
            onGoToForgotPasswordPressed()
        }

        gotoRegister.setOnClickListener {
            onGoToRegisterPressed()
        }

    }

    private fun onLoginButtonPressed() {
        val emailInput = etEmail.text.toString().trim()
        val passwordInput = etPassword.text.toString().trim()

        //Option 1: Login Success (Opted Out on Auto Login )
        if (emailInput.isNotEmpty() && passwordInput.isNotEmpty() && isValidEmailFormat && !isAutoLoginEnabled) {
            Toast.makeText(requireContext(), "Test: Login Successful. Auto Login Disabled.", Toast.LENGTH_SHORT).show()

        //Option 2: Login Success (Opted In on Auto Login)
        } else if (emailInput.isNotEmpty() && passwordInput.isNotEmpty() && isValidEmailFormat && isAutoLoginEnabled) {
            Toast.makeText(requireContext(), "Test: Login Successful. Auto Login Enabled.", Toast.LENGTH_SHORT).show()

        //Option 3: Register Failure. A field or more is empty
        } else if (emailInput.isEmpty() || passwordInput.isEmpty()) {
            Toast.makeText(requireContext(), "Test: Please fill in all fields", Toast.LENGTH_SHORT).show()

            //Option 3: Login Failure. Invalid input
        } else {
            Toast.makeText(requireContext(), "Test: Invalid input. Please try again.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onBioAuthButtonPressed(){
        Toast.makeText(requireContext(), "Test: Biometric Authentication not yet implemented.", Toast.LENGTH_SHORT).show()
    }

    private fun updateAutoLoginStatus(isChecked: Boolean) {
        isAutoLoginEnabled = isChecked
    }

    private fun onGoToRegisterPressed() {
        findNavController().navigate(R.id.to_registerFragment)
    }

    private fun onGoToForgotPasswordPressed() {
        findNavController().navigate(R.id.to_forgotPasswordDialog)
    }

}
