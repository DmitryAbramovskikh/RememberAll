package com.example.rememberall.ui.notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rememberall.ui.navigation.NoteDetailRoute

private val NOTE_SCREEN_EFFECT_KEY = "note_screen_effect_key"

@Composable
fun NoteDestination(navController: NavHostController)
{
    val viewModel: NotesViewModel = hiltViewModel()

    LaunchedEffect(NOTE_SCREEN_EFFECT_KEY) {
        viewModel.effect.collect {
            when(it)
            {
                is NotesContract.Effect.ShowDetail -> navController.navigate(NoteDetailRoute(it.id))
                is NotesContract.Effect.AddNew -> navController.navigate(NoteDetailRoute())
            }
        }
    }

    val effectListener: (NotesContract.Effect) -> Unit = { effect -> viewModel.setEffect(effect) }
    val intentListener: (NotesContract.Intent) -> Unit = { intent -> viewModel.setIntent(intent) }

    NotesScreen(viewModel.state.value, effectListener, intentListener)
}