package com.abhinav.stats.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.abhinav.stats.presentation.screens.activityhistory.ActivityHistoryScreen
import com.abhinav.stats.presentation.screens.home.HomeScreen
import com.abhinav.stats.presentation.screens.login.LoginScreen


@Composable
fun StatsNavGraph() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Keep the last-known username so the bottom bar can navigate back to Home correctly
    var currentUsername by remember { mutableStateOf("") }

    val showBottomBar = currentDestination?.hierarchy?.any {
        it.hasRoute(NavRoutes.Home::class) ||
                it.hasRoute(NavRoutes.Problems::class) ||
                it.hasRoute(NavRoutes.Settings::class)
    } == true

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController, currentUsername)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Login,

        ) {
            composable<NavRoutes.Login> {
                LoginScreen { username ->
                    currentUsername = username
                    navController.navigate(NavRoutes.Home(username)) {
                        popUpTo(NavRoutes.Login) {
                            inclusive = true
                        }
                    }
                }
            }

            composable<NavRoutes.Home> { backStackEntry ->
                val home: NavRoutes.Home = backStackEntry.toRoute()
                currentUsername = home.username
                HomeScreen(
                    username = home.username,
                    onActivityHistoryClick = {
                        navController.navigate(NavRoutes.ActivityHistory)
                    }
                )
            }

            composable<NavRoutes.Problems> {

            }

            composable<NavRoutes.Settings> {

            }

            composable<NavRoutes.ActivityHistory> {
                ActivityHistoryScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}