package com.abhinav.stats.data.remote.dto
import kotlinx.serialization.Serializable

@Serializable
data class ProfileDto(
    val username: String? = null,
    val name: String? = null,
    val ranking: Int? = null,
    val reputation: Int? = null
)