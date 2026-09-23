package com.abhinav.stats.data.remote

import com.abhinav.stats.data.Badge
import com.abhinav.stats.data.LanguageStat

import com.abhinav.stats.data.Submission
import com.abhinav.stats.data.UserStats
import com.abhinav.stats.data.remote.mock.MockData

class LeetCodeRepository(private val api: LeetCodeApiService = LeetCodeApi.service) {

    suspend fun fetchBadges(username: String): List<Badge> {
        val response = api.getBadges(username)
        return response.badges.map {
            Badge(
                id = it.id ?: it.label,
                name = it.label,
                iconUrl = normalizeIconUrl(it.icon)
            )
        }
    }

    private fun normalizeIconUrl(icon: String?): String {
        if (icon.isNullOrBlank()) return ""
        return if (icon.startsWith("http")) icon else "https://leetcode.com$icon"
    }

    suspend fun fetchUserStats(username: String): UserStats {
        val profile = api.getProfile(username)
        val solved = api.getSolvedStats(username)

        val totalAll = solved.totalSubmissionNum.find { it.difficulty == "All" }?.submissions
        val acAll = solved.acSubmissionNum.find { it.difficulty == "All" }?.submissions
        val acceptanceRate = if (totalAll != null && totalAll > 0 && acAll != null) {
            String.format("%.1f%%", acAll.toFloat() / totalAll * 100)
        } else {
            MockData.userStats.acceptanceRate
        }

        return MockData.userStats.copy(
            globalRank = profile.ranking?.let { "#$it" } ?: MockData.userStats.globalRank,
            totalSolved = solved.solvedProblem,
            acceptanceRate = acceptanceRate,
            easySolved = solved.easySolved,
            mediumSolved = solved.mediumSolved,
            hardSolved = solved.hardSolved
        )
    }

    suspend fun fetchTopLanguages(username: String): List<LanguageStat> {
        val response = api.getLanguageStats(username)
        return response.languageProblemCount
            .filter { it.problemsSolved > 0 }
            .sortedByDescending { it.problemsSolved }
            .take(3)
            .map { LanguageStat(it.languageName, it.problemsSolved) }
    }

    suspend fun fetchSubmissions(username: String, limit: Int = 20): List<Submission> {
        val response = api.getSubmissions(username, limit)
        return response.submission.map {
            Submission(
                id = "${it.titleSlug ?: it.title}-${it.timestamp}",
                title = it.title,
                status = it.statusDisplay,
                lang = it.lang,
                timeAgo = formatTimeAgo(it.timestamp)
            )
        }
    }

    private fun formatTimeAgo(timestampSeconds: String): String {
        val epochSeconds = timestampSeconds.toLongOrNull() ?: return ""
        val diffSeconds = (System.currentTimeMillis() / 1000) - epochSeconds
        return when {
            diffSeconds < 60 -> "Just now"
            diffSeconds < 3600 -> "${diffSeconds / 60}m ago"
            diffSeconds < 86400 -> "${diffSeconds / 3600}h ago"
            diffSeconds < 604800 -> "${diffSeconds / 86400}d ago"
            else -> "${diffSeconds / 604800}w ago"
        }
    }
}