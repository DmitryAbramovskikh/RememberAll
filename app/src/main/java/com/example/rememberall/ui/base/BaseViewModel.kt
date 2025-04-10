package com.example.rememberall.ui.base

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

interface BaseContract {
    interface ViewIntent
    interface ViewUIState
    interface ViewSideEffect
}

data class ViewError(val message: String = "")

abstract class BaseViewModel<VS: BaseContract.ViewUIState, VI: BaseContract.ViewIntent, VSE: BaseContract.ViewSideEffect>(val stringProvider: StringProvider? = null): ViewModel()
{
    private val _state = mutableStateOf(setInitState())
    var state: State<VS> = _state

    private val _effect = MutableSharedFlow<VSE>()
    val effect: Flow<VSE> = _effect

    private val _error = MutableSharedFlow<ViewError>()
    val error: Flow<ViewError> = _error

    private val _intents = MutableSharedFlow<VI>()

    init
    {
        viewModelScope.launch {
            _intents
                .collect { dispatchIntent(it) }
        }
    }

    abstract suspend fun dispatchIntent(intent: VI)
    abstract fun setInitState(): VS

    fun setState(reducer: VS.() -> VS)
    {
        _state.value = _state.value.reducer()
    }

    fun setIntent(intent: VI) = viewModelScope.launch { _intents.emit(intent) }

    fun setEffect(effect: VSE) = viewModelScope.launch { _effect.emit(effect) }

    protected fun setError(error: ViewError) = viewModelScope.launch { _error.emit(error) }
}