package com.example.rememberall.model.services

import com.example.rememberall.model.entity.Note
import kotlinx.coroutines.flow.Flow

interface NoteService
{
    fun fetchAll(): Flow<List<Note>>

    fun getById(id: Int): Flow<Note?>

    fun save(note: Note)
}