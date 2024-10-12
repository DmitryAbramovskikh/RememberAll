package com.example.rememberall.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel()
{
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