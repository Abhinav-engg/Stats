package com.abhinav.stats.presentation.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var usernameError by mutableStateOf<String?>(null)
        private set

    var passwordError by mutableStateOf<String?>(null)
        private set

    fun onUsernameChange(newUsername: String) {
        username = newUsername
        usernameError = null
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
        passwordError = null
    }

    fun onContinueClick(onSuccess: (String) -> Unit) {
        val trimmedUsername = username.trim()

        usernameError = when {
            trimmedUsername.isEmpty() -> "Username can't be empty"
            trimmedUsername.contains(" ") -> "Username can't contain spaces"
            trimmedUsername.length < 3 -> "Username must be at least 3 characters"
            else -> null
        }

        passwordError = when {
            password.isEmpty() -> "Password can't be empty"
            password.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }

        if (usernameError == null && passwordError == null) {
            onSuccess(trimmedUsername)
        }
    }
}