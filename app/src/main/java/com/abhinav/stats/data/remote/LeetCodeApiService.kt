package com.abhinav.stats.data.remote

import com.abhinav.stats.data.remote.dto.BadgeResponseDto
import com.abhinav.stats.data.remote.dto.LanguageStatsDto
import com.abhinav.stats.data.remote.dto.ProfileDto
import com.abhinav.stats.data.remote.dto.SolvedStatsDto
import com.abhinav.stats.data.remote.dto.SubmissionResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LeetCodeApiService {
    @GET("{username}/badges")
    suspend fun getBadges(@Path("username") username: String): BadgeResponseDto

    @GET("{username}")
    suspend fun getProfile(@Path("username") username: String): ProfileDto

    @GET("{username}/solved")
    suspend fun getSolvedStats(@Path("username") username: String): SolvedStatsDto

    @GET("{username}/language")
    suspend fun getLanguageStats(@Path("username") username: String): LanguageStatsDto

    @GET("{username}/submission")
    suspend fun getSubmissions(
        @Path("username") username: String,
        @Query("limit") limit: Int
    ): SubmissionResponseDto
}