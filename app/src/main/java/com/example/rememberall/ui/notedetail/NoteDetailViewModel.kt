package com.example.rememberall.ui.notedetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.services.NoteService
import com.example.rememberall.ui.base.BaseViewModel
import dagger.assisted.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date

@HiltViewModel(assistedFactory = NoteDetailViewModel.Factory::class)
class NoteDetailViewModel @AssistedInject constructor(private val noteService: NoteService,
                                                      @Assisted private val id: Int)
    : BaseViewModel<NoteDetailContract.State, NoteDetailContract.Intent, NoteDetailContract.Effect>() {

    @AssistedFactory
    interface Factory {
        fun create(id: Int): NoteDetailViewModel
    }

    private var createDate = Date()
    private var lastEditedDate = Date()

    init {
        viewModelScope.launch {
            noteService
                .getById(id)
                .collect {
                    setState { copy(title = it?.title ?: "", text = it?.text ?: "") }
                    createDate = it?.created ?: Date()
                    lastEditedDate = it?.edited ?: Date()
                }
        }
    }

    override suspend fun dispatchIntent(intent: NoteDetailContract.Intent) {
        when(intent)
        {
            is NoteDetailContract.Intent.ChangeTitle -> { changeTitle(intent.title) }
            is NoteDetailContract.Intent.ChangeText -> { changeText(intent.text) }
            is NoteDetailContract.Intent.Save -> { onSave() }
        }
    }

    override fun setInitState(): NoteDetailContract.State = NoteDetailContract.State()

    private fun changeTitle(title: String)
    {
        setState { copy(title = title, isChanged = true) }
    }

    private fun changeText(text: String)
    {
        setState { copy(text = text, isChanged = true) }
    }

    private suspend fun onSave()
    {
        if (!state.value.isChanged) return

        val title = state.value.title
        val text = state.value.text

        noteService
            .save(Note(id, title, text, createDate, Date()))

        setEffect(NoteDetailContract.Effect.Back)
    }
}

