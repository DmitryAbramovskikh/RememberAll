package com.example.rememberall.ui.notes

import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.services.NoteService
import com.example.rememberall.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteService: NoteService): BaseViewModel()
{
    val notes = noteService
        .fetchAll()
        .map { it.map { note: Note -> NoteVM(note) } }
}