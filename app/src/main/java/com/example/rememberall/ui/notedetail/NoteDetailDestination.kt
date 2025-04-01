package com.example.rememberall.ui.notedetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

private val NOTE_DETAIL_SCREEN_EFFECT_KEY = "note_detail_screen_effect_key"

@Composable
fun NoteDetailDestination(navController: NavHostController, noteId: Int) {

    val viewModel = hiltViewModel<NoteDetailViewModel, NoteDetailViewModel.Factory> {
        it.create(noteId)
    }

    LaunchedEffect(NOTE_DETAIL_SCREEN_EFFECT_KEY) {
        viewModel.effect.collect { effect ->
            when(effect) {
                NoteDetailContract.Effect.Back -> navController.popBackStack()
            }
        }
    }

    val intentHandler: (NoteDetailContract.Intent) -> Unit = { intent -> viewModel.setIntent(intent) }
    val effectHandler: (NoteDetailContract.Effect) -> Unit = { effect -> viewModel.setEffect(effect) }

    NoteDetailScreen(viewModel.state.value, intentHandler, effectHandler)
}