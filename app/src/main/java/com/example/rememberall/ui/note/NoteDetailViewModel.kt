package com.example.rememberall.ui.note

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.rememberall.R
import com.example.rememberall.ui.base.StringProvider
import dagger.assisted.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel(assistedFactory = NoteDetailViewModel.Factory::class)
class NoteDetailViewModel @AssistedInject constructor(stringProvider: StringProvider, @Assisted id: Int): ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(id: Int): NoteDetailViewModel
    }

    var title: MutableState<String> = mutableStateOf("")
    val text = mutableStateOf("")
}

