package com.abhinav.stats.data.remote.dto;
import kotlinx.serialization.Serializable;

@Serializable
data class BadgeResponseDto(
    val badgesCount: Int = 0,
    val badges: List<BadgeItemDto> = emptyList(),
    val upcomingBadges: List<BadgeItemDto> = emptyList(),
    val activeBadge: BadgeItemDto? = null
)

