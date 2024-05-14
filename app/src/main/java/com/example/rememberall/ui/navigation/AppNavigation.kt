package com.example.rememberall.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.rememberall.ui.main.MainScreen
import com.example.rememberall.ui.note.NoteDetailScreen

@Composable
fun AppNavigationGraph(navController: NavHostController)
{
    NavHost(navController = navController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController)
        }
        composable(Routes.NOTE_DETAIL_SCREEN) {
            NoteDetailScreen(navController)
        }
    }
}