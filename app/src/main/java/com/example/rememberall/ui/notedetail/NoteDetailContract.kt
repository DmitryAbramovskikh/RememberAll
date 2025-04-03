package com.example.rememberall.ui.notedetail

import com.example.rememberall.ui.base.BaseContract
import com.example.rememberall.ui.base.BaseContract.ViewIntent
import com.example.rememberall.ui.base.BaseContract.ViewSideEffect
import com.example.rememberall.ui.base.BaseContract.ViewUIState

class NoteDetailContract: BaseContract {

    data class State(val title: String = "",
                     val text: String = "",
                     val isChanged: Boolean = false,
                     val isLoading: Boolean = false): ViewUIState

    sealed interface Effect: ViewSideEffect
    {
        object Back: Effect
    }

    sealed interface Intent: ViewIntent
    {
        data class ChangeTitle(val title: String): Intent
        data class ChangeText(val text: String): Intent
        object Save: Intent
    }

}