package com.example.rememberall.ui.base

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel()
{
    abstract fun getTitle(): MutableState<String>

    open val stringProvider: StringProvider? = null

    init
    {
        viewModelScope
            .launch {
                delay(100)
                onInit()
            }
    }

    open suspend fun onInit() {

    }
}