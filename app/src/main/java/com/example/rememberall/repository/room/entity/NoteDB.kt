package com.example.rememberall.repository.room.entity

import androidx.room.*
import com.example.rememberall.model.entity.Note
import com.example.rememberall.repository.entity.NoteInterface
import java.util.Date

const val NOTES_TABLE = "notes"

@Entity(tableName = NOTES_TABLE)
data class NoteDB(
    @PrimaryKey
    @ColumnInfo("id")
    override val id: Int,
    @ColumnInfo("title")
    override val title: String,
    @ColumnInfo("text")
    override val text: String,
    @ColumnInfo("created")
    override val created: Date,
    @ColumnInfo("edited")
    override val edited: Date) : NoteInterface

{
    constructor(entity: Note): this (
        entity.id,
        entity.title,
        entity.text,
        entity.created,
        entity.edited
    )
}