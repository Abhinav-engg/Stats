package com.abhinav.stats.data.remote

import com.abhinav.stats.data.Badge

class LeetCodeRepository(private val api: LeetCodeApiService = LeetCodeApi.service) {

    suspend fun fetchBadges(username: String): List<Badge> {
        val response = api.getBadges(username)
        return response.badges.map {
            Badge(
                id = it.id ?: it.label,
                name = it.label,
                iconUrl = it.icon.orEmpty()
            )
        }
    }
}