package com.abhinav.stats.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.stats.data.Badge
import com.abhinav.stats.data.LanguageStat
import com.abhinav.stats.data.UserStats
import com.abhinav.stats.data.remote.LeetCodeRepository
import com.abhinav.stats.data.remote.mock.MockData
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: LeetCodeRepository = LeetCodeRepository()
) : ViewModel() {

    var userStats by mutableStateOf(MockData.userStats)
        private set

    var badges by mutableStateOf(emptyList<Badge>())
        private set

    var topLanguages by mutableStateOf(emptyList<LanguageStat>())
        private set

    var coreTopics by mutableStateOf(emptyList<String>())
        private set

    var badgesLoading by mutableStateOf(false)
        private set

    fun loadStats(username: String) {
        coreTopics = MockData.coreTopics

        viewModelScope.launch {
            badgesLoading = true
            badges = try {
                repository.fetchBadges(username)
            } catch (e: Exception) {
                emptyList()
            }
            badgesLoading = false
        }

        viewModelScope.launch {
            userStats = try {
                repository.fetchUserStats(username)
            } catch (e: Exception) {
                MockData.userStats
            }
        }

        viewModelScope.launch {
            topLanguages = try {
                repository.fetchTopLanguages(username)
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}