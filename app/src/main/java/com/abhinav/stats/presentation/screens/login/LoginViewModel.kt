package com.abhinav.stats.presentation.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var username by mutableStateOf("")
        private set

    var usernameError by mutableStateOf<String?>(null)
        private set

    fun onUsernameChange(newUsername: String) {
        username = newUsername
        usernameError = null
    }

    fun onContinueClick(onSuccess: (String) -> Unit) {
        val trimmedUsername = username.trim()

        usernameError = when {
            trimmedUsername.isEmpty() -> "Username can't be empty"
            trimmedUsername.contains(" ") -> "Username can't contain spaces"
            trimmedUsername.length < 3 -> "Username must be at least 3 characters"
            else -> null
        }

        if (usernameError == null) {
            onSuccess(trimmedUsername)
        }
    }
}