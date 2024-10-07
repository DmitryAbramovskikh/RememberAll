package com.example.rememberall.ui.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rememberall.model.services.NoteService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(noteService: NoteService): ViewModel()
{
    val notes: MutableStateFlow<List<NoteVM>> = MutableStateFlow(listOf())

    init
    {
        viewModelScope
            .launch {
                noteService
                    .fetchAll()
                    .map { it.map { note -> NoteVM(note) } }
                    .collect {
                        notes.value = it
                    }
            }
    }
}