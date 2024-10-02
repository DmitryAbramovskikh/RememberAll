package com.example.rememberall.ui.base

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor (): ViewModel()
{
    @Inject
    lateinit var stringProvider: StringProvider
}