package com.example.rememberall.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.rememberall.ui.image.ImageCompose
import com.example.rememberall.ui.main.MainScreen
import com.example.rememberall.ui.note.NoteDetailCompose

@Composable
fun AppNavigationHost(navController: NavHostController, padding: PaddingValues)
{
    NavHost(navController = navController, startDestination = MainScreen) {

        composable<MainScreen> {
            MainScreen(
                onClickAddNew = { navController.navigate(NoteDetailScreen(-1)) },
                onClickShowDetail = { navController.navigate(NoteDetailScreen(it)) }
            )
        }

        composable<NoteDetailScreen> {
            val noteDetailScreen = it.toRoute<NoteDetailScreen>()
            NoteDetailCompose(noteDetailScreen.id)
        }

        composable<ImageScreen>{
            ImageCompose()
        }
    }
}