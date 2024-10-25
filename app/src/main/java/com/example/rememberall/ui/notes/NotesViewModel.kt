package com.example.rememberall.ui.notes

import androidx.compose.runtime.mutableStateOf
import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.services.NoteService
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.base.StringProvider
import com.example.rememberall.ui.note.NoteDetailViewModel
import dagger.assisted.AssistedFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteService: NoteService,
                                         override val stringProvider: StringProvider?): BaseViewModel()
{
    val notes = noteService
        .fetchAll()
        .map { it.map { note: Note -> NoteVM(note, parent = this) } }

    override fun getTitle() = mutableStateOf("Заметки")
}