package com.abhinav.stats.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface NavRoutes {

    @Serializable
    data object Login : NavRoutes

    @Serializable
    data class Home(val username: String) : NavRoutes

    @Serializable
    data object Problems : NavRoutes

    @Serializable
    data object Settings : NavRoutes

    @Serializable
    data object ActivityHistory : NavRoutes


    @Serializable
    data object AllBadges : NavRoutes
}