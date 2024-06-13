package com.example.rememberall.ui.notes

import com.example.rememberall.model.entity.Note
import com.example.rememberall.ui.local.toReadableDate

class NoteVM(val id: Int, val created: String, val edited: String, val text: String)
{
    constructor(note: Note): this (
        note.id,
        note.created.toReadableDate(),
        note.edited.toReadableDate(),
        note.text
    )

    fun onCLick() {
        TODO("Not implements yet")
    }
}