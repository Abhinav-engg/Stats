package com.abhinav.stats.presentation.navigation

import android.net.Uri

object NavRoutes {
    const val LOGIN = "login"
    const val HOME = "home/{username}"

    fun home(username: String): String {
        return "home/${Uri.encode(username)}"
    }
}
