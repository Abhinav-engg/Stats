package com.abhinav.stats.presentation.screens.problems

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhinav.stats.data.Submission
import com.abhinav.stats.data.remote.LeetCodeRepository
import kotlinx.coroutines.launch

class SolvedProblemsViewModel(
    private val repository: LeetCodeRepository = LeetCodeRepository()
) : ViewModel() {

    var submissions by mutableStateOf(emptyList<Submission>())
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun loadSubmissions(username: String) {
        viewModelScope.launch {
            isLoading = true
            submissions = try {
                repository.fetchSubmissions(username)
            } catch (e: Exception) {
                emptyList()
            }
            isLoading = false
        }
    }
}