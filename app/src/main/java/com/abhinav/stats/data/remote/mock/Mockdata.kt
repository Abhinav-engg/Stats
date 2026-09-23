package com.abhinav.stats.data.remote.mock

import com.abhinav.stats.data.Difficulty
import com.abhinav.stats.data.LanguageStat
import com.abhinav.stats.data.Submission
import com.abhinav.stats.data.UserStats

object MockData {
    val userStats = UserStats(
        globalRank = "#42,108",
        topPercentage = "Top 6.4% in Weekly Contests",
        totalSolved = 782,
        totalProblems = 3120,
        acceptanceRate = "64.2%",
        easySolved = 412,
        easyTotal = 820,
        mediumSolved = 296,
        mediumTotal = 1640,
        hardSolved = 74,
        hardTotal = 660,
        speedPercentile = "Beats avg. 86.4%",
        paceMetric = "32 Daily Solves"
    )


    val topLanguages = listOf(
        LanguageStat("Python", 492),
        LanguageStat("TypeScript", 184),
        LanguageStat("C++", 106)
    )

    val coreTopics = listOf("DP", "Trees", "Graphs")

    val allTopics = listOf("Array", "DP", "Tree", "Binary Search", "Graph")

    val recentSubmissions = emptyList<Submission>()
}