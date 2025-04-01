package com.example.rememberall.model.services

import com.example.rememberall.model.entity.Note
import kotlinx.coroutines.flow.Flow

interface NoteService
{
    suspend fun fetchAll(): Flow<List<Note>>

    suspend fun getById(id: Int): Flow<Note?>

    suspend fun save(note: Note): Flow<Boolean>

    suspend fun delete(id: Int): Flow<Boolean>
}