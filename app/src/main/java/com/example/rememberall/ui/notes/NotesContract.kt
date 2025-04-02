package com.example.rememberall.ui.notes

import com.example.rememberall.ui.base.BaseContract

class NotesContract: BaseContract {

    data class State(
        val isLoading: Boolean,
        val notes: List<NoteVM> = listOf()): BaseContract.ViewUIState

    sealed interface Intent: BaseContract.ViewIntent
    {
        class Delete(val id: Int): Intent
    }

    sealed interface Effect: BaseContract.ViewSideEffect
    {
        class ShowDetail(val id: Int): Effect
        object AddNew: Effect
    }
}