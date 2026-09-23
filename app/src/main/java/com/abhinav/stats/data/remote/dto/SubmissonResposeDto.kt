package com.abhinav.stats.data.remote.dto
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionItemDto(
    val title: String,
    val titleSlug: String? = null,
    val timestamp: String,
    val statusDisplay: String,
    val lang: String
)

@Serializable
data class SubmissionResponseDto(
    val count: Int = 0,
    val submission: List<SubmissionItemDto> = emptyList()
)