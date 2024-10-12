package com.example.rememberall.ui.notes

import com.example.rememberall.model.entity.Note
import com.example.rememberall.ui.local.toReadableDate

class NoteVM(val id: Int, val title: String, val text: String, val created: String, val edited: String)
{
    constructor(note: Note): this (
        note.id,
        note.title,
        note.text,
        note.created.toReadableDate(),
        note.edited.toReadableDate()
    )
}