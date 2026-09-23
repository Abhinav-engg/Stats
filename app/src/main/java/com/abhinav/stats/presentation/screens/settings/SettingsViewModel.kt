package com.abhinav.stats.presentation.screens.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.stats.data.remote.LeetCodeRepository
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val repository: LeetCodeRepository = LeetCodeRepository()
) : ViewModel() {

    var rank by mutableStateOf<String?>(null)
        private set

    fun loadProfile(username: String) {
        viewModelScope.launch {
            rank = try {
                repository.fetchProfileRank(username)
            } catch (e: Exception) {
                null
            }
        }
    }
}