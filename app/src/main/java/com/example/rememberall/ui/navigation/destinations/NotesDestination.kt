package com.example.rememberall.ui.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.example.rememberall.ui.base.components.BaseDestination
import com.example.rememberall.ui.navigation.AppRoutes
import com.example.rememberall.ui.notes.NotesContract
import com.example.rememberall.ui.notes.NotesScreen
import com.example.rememberall.ui.notes.NotesViewModel

private val NOTE_SCREEN_EFFECT_KEY = "note_screen_effect_key"

@Composable
fun NoteDestination(navController: NavHostController)  =
    BaseDestination<NotesContract.State, NotesContract.Effect, NotesContract.Intent, NotesViewModel> { state, effect, effectListener, intentListener ->

        LaunchedEffect(NOTE_SCREEN_EFFECT_KEY) {
            effect.collect {
                when(it)
                {
                    is NotesContract.Effect.ShowDetail -> navController.navigate(AppRoutes.NoteDetailRoute(it.id))
                    is NotesContract.Effect.AddNew -> navController.navigate(AppRoutes.NoteDetailRoute())
                }
            }
        }

        NotesScreen(state, effectListener, intentListener)
    }