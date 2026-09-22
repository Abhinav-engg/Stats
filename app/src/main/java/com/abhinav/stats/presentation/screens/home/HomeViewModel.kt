package com.abhinav.stats.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.abhinav.stats.data.Badge
import com.abhinav.stats.data.LanguageStat
import com.abhinav.stats.data.MockData
import com.abhinav.stats.data.UserStats

class HomeViewModel : ViewModel() {

    var userStats by mutableStateOf(MockData.userStats)
        private set

    var badges by mutableStateOf(emptyList<Badge>())
        private set

    var topLanguages by mutableStateOf(emptyList<LanguageStat>())
        private set

    var coreTopics by mutableStateOf(emptyList<String>())
        private set

    fun loadStats(username: String) {
        userStats = MockData.userStats
        badges = MockData.badges
        topLanguages = MockData.topLanguages
        coreTopics = MockData.coreTopics
    }
}