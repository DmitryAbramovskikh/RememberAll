package com.example.rememberall.ui.note

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.services.NoteService
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.base.StringProvider
import dagger.assisted.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date

@HiltViewModel(assistedFactory = NoteDetailViewModel.Factory::class)
class NoteDetailViewModel @AssistedInject constructor(stringProvider: StringProvider,
                                                      private val noteService: NoteService,
                                                      @Assisted private val id: Int): BaseViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(id: Int): NoteDetailViewModel
    }

    var title by mutableStateOf("")
    var text by mutableStateOf("")
    var isChanged by mutableStateOf(false)

    private var createDate = Date()
    private var lastEditedDate = Date()

    override suspend fun onInit()
    {
        noteService
            .getById(id)
            .collect {
                title = it?.title ?: ""
                text = it?.text ?: ""
                createDate = it?.created ?: Date()
                lastEditedDate = it?.edited ?: Date()
            }
    }

    override fun getTitle() = mutableStateOf("Заметка")

    fun onNoteEdit(title: String? = null, text: String? = null) {
        isChanged = true

        title?.let {
            this.title = it
        }
        text?.let {
            this.text = it
        }

    }

    fun onSave()
    {

        viewModelScope.launch {
            if (!isChanged) return@launch
                noteService.save(Note(id, title, text, createDate, Date())).collect{}
        }
    }
}

