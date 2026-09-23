package com.abhinav.stats.data.remote.dto
import kotlinx.serialization.Serializable

@Serializable
data class LanguageProblemCountDto(
    val languageName: String,
    val problemsSolved: Int
)

@Serializable
data class LanguageStatsDto(
    val languageProblemCount: List<LanguageProblemCountDto> = emptyList()
)