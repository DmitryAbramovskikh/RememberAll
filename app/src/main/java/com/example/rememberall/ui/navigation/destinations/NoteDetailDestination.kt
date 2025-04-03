package com.example.rememberall.ui.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rememberall.ui.base.components.BaseDestination
import com.example.rememberall.ui.notedetail.NoteDetailContract
import com.example.rememberall.ui.notedetail.NoteDetailScreen
import com.example.rememberall.ui.notedetail.NoteDetailViewModel

private val NOTE_DETAIL_SCREEN_EFFECT_KEY = "note_detail_screen_effect_key"

@Composable
fun NoteDetailDestination(navController: NavHostController, noteId: Int) {
    val viewModel = hiltViewModel<NoteDetailViewModel, NoteDetailViewModel.Factory> {
        it.create(noteId)
    }

    BaseDestination<NoteDetailContract.State, NoteDetailContract.Effect, NoteDetailContract.Intent, NoteDetailViewModel>(viewModel) { state, effect, effectListener, intentListener ->

        LaunchedEffect(NOTE_DETAIL_SCREEN_EFFECT_KEY) {
            effect.collect { effect ->
                when(effect) {
                    NoteDetailContract.Effect.Back -> navController.popBackStack()
                }
            }
        }

        NoteDetailScreen(state, intentListener, effectListener)
    }
}