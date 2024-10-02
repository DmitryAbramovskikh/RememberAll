package com.example.rememberall.model.services

import com.example.rememberall.model.entity.Note
import kotlinx.coroutines.flow.Flow

interface NoteService
{
    fun fetchAll(): Flow<List<Note>>

    suspend fun save(note: Note)
}