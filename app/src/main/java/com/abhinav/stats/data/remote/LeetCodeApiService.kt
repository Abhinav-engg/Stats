package com.abhinav.stats.data.remote

import com.abhinav.stats.data.remote.dto.BadgeResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface LeetCodeApiService {
    @GET("{username}/badges")
    suspend fun getBadges(@Path("username") username: String): BadgeResponseDto
}