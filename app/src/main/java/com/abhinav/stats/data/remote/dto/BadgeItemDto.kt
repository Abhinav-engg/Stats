package com.abhinav.stats.data.remote.dto
import kotlinx.serialization.Serializable
@Serializable
data class BadgeItemDto(
    val id: String? = null,
    val displayName: String? = null,
    val name: String? = null,
    val icon: String? = null,
    val creationDate: String? = null
) {
    val label: String get() = displayName ?: name ?: "Badge"
}