package com.abhinav.stats.presentation.screens.badges

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.stats.data.Badge
import com.abhinav.stats.data.remote.LeetCodeRepository
import kotlinx.coroutines.launch

class AllBadgesViewModel(
    private val repository: LeetCodeRepository = LeetCodeRepository()
) : ViewModel() {

    var badges by mutableStateOf(emptyList<Badge>())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadBadges(username: String) {
        viewModelScope.launch {
            isLoading = true
            badges = try {
                repository.fetchBadges(username)
            } catch (e: Exception) {
                emptyList()
            }
            isLoading = false
        }
    }
}