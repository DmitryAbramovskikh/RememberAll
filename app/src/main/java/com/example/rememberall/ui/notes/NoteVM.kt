package com.example.rememberall.ui.notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.rememberall.R
import com.example.rememberall.model.entity.Note
import com.example.rememberall.ui.base.BaseVM
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.local.toReadableDate
import java.util.Date

class NoteVM(val id: Int, val title: String, val text: String, val createDate: Date, val editDate: Date, parent: BaseViewModel? = null): BaseVM(parent)
{
    var createdText by mutableStateOf("")
    var editedText by mutableStateOf("")

    constructor(note: Note, parent: BaseViewModel? = null): this (
        note.id,
        note.title,
        note.text,
        note.created,
        note.edited,
        parent
    )

    init
    {
        createdText = getString(R.string.note_detail_created) + createDate.toReadableDate()
        editedText = getString(R.string.note_detail_edited) + editDate.toReadableDate()
    }
}