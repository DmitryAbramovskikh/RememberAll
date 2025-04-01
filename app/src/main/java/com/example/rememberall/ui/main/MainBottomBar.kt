package com.example.rememberall.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rememberall.ui.main.bottomnavigation.TopLevelBottomRoute
import com.example.rememberall.ui.navigation.MainRoute
import com.example.rememberall.ui.navigation.NotesRoute
import com.example.rememberall.ui.theme.md_theme_dark_primaryContainer

val topLevelBottomRoutes = listOf(
    TopLevelBottomRoute("Главный", MainRoute, "MainScreen", Icons.Outlined.Home),
    TopLevelBottomRoute("Заметки", NotesRoute, "NotesScreen", Icons.AutoMirrored.Outlined.List)
)

@Composable
fun MainBottomBar(modifier: Modifier, navController: NavHostController, state: MutableState<Boolean>) {
    NavigationBar(
        modifier = modifier,
        containerColor = md_theme_dark_primaryContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        topLevelBottomRoutes.forEach { route ->
            NavigationBarItem(
                label = {
                    Text(text = route.name)
                },
                icon = {
                    Icon(imageVector = route.icon, contentDescription = "")
                },
                selected = currentRoute == route.route.javaClass.name,
                onClick = {
                    navController.navigate(route.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    selectedIconColor = Color.White,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}