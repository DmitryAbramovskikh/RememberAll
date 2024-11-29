package com.example.rememberall.model.entity

import com.example.rememberall.repository.entity.NoteInterface
import java.util.Date

data class Note(val id: Int?,
                val title: String,
                val text: String,
                val created: Date,
                val edited: Date)
{
    constructor(entity: NoteInterface): this (
        entity.id,
        entity.title,
        entity.text,
        entity.created,
        entity.edited
    )
}