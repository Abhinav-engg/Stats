package com.abhinav.stats.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.abhinav.stats.ui.theme.Primary
import com.abhinav.stats.ui.theme.Surface
import com.abhinav.stats.ui.theme.TextSecondary
import kotlin.reflect.KClass

private data class BottomNavItem(
    val routeClass: KClass<out NavRoutes>,
    val label: String,
    val icon: ImageVector,
    val route: (username: String) -> NavRoutes
)

private val bottomNavItems = listOf(
    BottomNavItem(NavRoutes.Home::class, "Home", Icons.Default.Home) { username ->
        NavRoutes.Home(username)
    },
    BottomNavItem(NavRoutes.Problems::class, "Problems", Icons.Default.Code) {
        NavRoutes.Problems
    },
    BottomNavItem(NavRoutes.Settings::class, "Settings", Icons.Default.Settings) {
        NavRoutes.Settings
    }
)

@Composable
fun BottomNavBar(
    navController: NavHostController,
    currentUsername: String
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Surface,
        tonalElevation = 0.dp

    ) {
        bottomNavItems.forEach { item ->
            val selected = currentDestination?.hierarchy?.any {
                it.hasRoute(item.routeClass)
            } == true

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route(currentUsername)) {
                            popUpTo(NavRoutes.Home(currentUsername)) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(text = item.label, fontWeight = FontWeight.Medium) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Primary,
                    selectedTextColor = Primary,
                    unselectedIconColor = TextSecondary,
                    unselectedTextColor = TextSecondary,
                    indicatorColor = Primary.copy(alpha = 0.15f)
                )
            )
        }
    }
}