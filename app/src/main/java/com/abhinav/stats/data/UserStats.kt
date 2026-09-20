package com.abhinav.stats.data

data class UserStats (
    val globalRank: String,
    val topPercentage: String,
    val totalSolved: Int,
    val totalProblems: Int,
    val acceptanceRate: String,
    val easySolved: Int,
    val easyTotal: Int,
    val mediumSolved: Int,
    val mediumTotal: Int,
    val hardSolved: Int,
    val hardTotal: Int,
    val speedPercentile: String,
    val paceMetric: String
)