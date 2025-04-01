package com.example.rememberall.ui.notes

import com.example.rememberall.ui.base.ViewIntent
import com.example.rememberall.ui.base.ViewSideEffect
import com.example.rememberall.ui.base.ViewUIState

class NotesContract {

    data class ViewState(
        val isLoading: Boolean,
        val notes: List<NoteVM> = listOf()): ViewUIState

    sealed interface Intent: ViewIntent
    {
        class Delete(val id: Int): Intent
    }

    sealed interface Effect: ViewSideEffect
    {
        class ShowDetail(val id: Int): Effect
        object AddNew: Effect
    }
}