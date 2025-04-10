package com.example.rememberall.ui.notes

import androidx.lifecycle.viewModelScope
import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.services.NoteService
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.base.StringProvider
import com.example.rememberall.ui.base.ViewError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val noteService: NoteService,
                                         stringProvider: StringProvider? = null): BaseViewModel<NotesContract.State, NotesContract.Intent, NotesContract.Effect>(stringProvider)
{
    init {
        fetchNotes()
    }

    override suspend fun dispatchIntent(intent: NotesContract.Intent) {
        when(intent)
        {
            //is NotesContract.Intent.Delete -> { delete(intent.id) }
            is NotesContract.Intent.Delete -> { setError(ViewError("Error")) }
        }
    }

    override fun setInitState(): NotesContract.State = NotesContract.State(true)

    private suspend fun delete(noteId: Int)
    {
        setState { copy(isLoading = true) }

        noteService
            .delete(noteId)
            .collect {
                fetchNotes()
            }
    }

    private fun fetchNotes() = viewModelScope.launch {
        setState { copy(isLoading = true) }
        noteService.fetchAll()
            .map { it.map { note: Note -> NoteVM(note, parent = this@NotesViewModel) } }
            .collect {
                setState { copy(isLoading = false, notes = it) }
            }
    }
}