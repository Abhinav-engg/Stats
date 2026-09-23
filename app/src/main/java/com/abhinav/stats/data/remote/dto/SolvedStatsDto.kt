package com.abhinav.stats.data.remote.dto
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionCountDto(
    val difficulty: String,
    val count: Int,
    val submissions: Int
)

@Serializable
data class SolvedStatsDto(
    val solvedProblem: Int = 0,
    val easySolved: Int = 0,
    val mediumSolved: Int = 0,
    val hardSolved: Int = 0,
    val totalSubmissionNum: List<SubmissionCountDto> = emptyList(),
    val acSubmissionNum: List<SubmissionCountDto> = emptyList()
)