package com.abhinav.stats.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abhinav.stats.presentation.screens.home.HomeScreen
import com.abhinav.stats.presentation.screens.login.LoginScreen

@Composable
fun StatsNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.LOGIN
    ) {
        composable(route = NavRoutes.LOGIN) {
            LoginScreen { username ->
                navController.navigate(NavRoutes.home(username)) {
                    popUpTo(NavRoutes.LOGIN) {
                        inclusive = true
                    }
                }
            }
        }

        composable(
            route = NavRoutes.HOME,
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username").orEmpty()
            HomeScreen(username = username)
        }
    }
}
