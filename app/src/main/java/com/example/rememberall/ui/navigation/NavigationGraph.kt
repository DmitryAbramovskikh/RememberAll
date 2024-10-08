package com.example.rememberall.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.rememberall.ui.image.ImageCompose
import com.example.rememberall.ui.main.MainScreen
import com.example.rememberall.ui.note.*

@Composable
fun AppNavigationHost(navController: NavHostController, modifier: Modifier = Modifier)
{
    NavHost(navController = navController, startDestination = MainScreen, modifier = modifier) {

        composable<MainScreen> {
            MainScreen(
                onClickAddNew = { navController.navigate(NoteDetailScreen(-1)) },
                onClickShowDetail = { navController.navigate(NoteDetailScreen(it)) }
            )
        }

        composable<NoteDetailScreen> { backStackEntry ->
            val noteDetailScreen = backStackEntry.toRoute<NoteDetailScreen>()
            val noteViewModel = hiltViewModel<NoteDetailViewModel, NoteDetailViewModel.Factory> { it.create(noteDetailScreen.id) }
            NoteDetailCompose(noteViewModel)
        }

        composable<ImageScreen>{
            ImageCompose()
        }
    }
}