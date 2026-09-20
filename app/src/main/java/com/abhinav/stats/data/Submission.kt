package com.abhinav.stats.data

data class Submission(
    val id: Int,
    val title: String,
    val difficulty: Difficulty,
    val tags: List<String>,
    val timeAgo: String,
    val runtime: String,
    val beatsPercentage: String
)