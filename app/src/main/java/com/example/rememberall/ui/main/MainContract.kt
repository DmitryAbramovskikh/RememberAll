package com.example.rememberall.ui.main

import com.example.rememberall.ui.base.ViewIntent
import com.example.rememberall.ui.base.ViewSideEffect
import com.example.rememberall.ui.base.ViewUIState

class MainContract {

    data class State(val isLoading: Boolean): ViewUIState

    sealed interface Intent: ViewIntent

    sealed interface Effect: ViewSideEffect
}