package com.example.rememberall.ui.main

import com.example.rememberall.ui.base.BaseContract

class MainContract: BaseContract {

    data class State(val isLoading: Boolean): BaseContract.ViewUIState

    sealed interface Intent: BaseContract.ViewIntent

    sealed interface Effect: BaseContract.ViewSideEffect
}