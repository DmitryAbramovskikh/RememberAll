package com.example.rememberall.model

import com.example.rememberall.model.entity.Note
import com.example.rememberall.repository.entity.NoteInterface
import kotlinx.coroutines.flow.Flow

interface NoteRepositoryInterface
{
    fun fetchAll(): Flow<List<NoteInterface>>

    fun getById(id: Int): Flow<NoteInterface?>

    fun getByIds(ids: List<Int>): Flow<List<NoteInterface>>

    suspend fun insert(note: Note)

    suspend fun delete(noteId: Int): Flow<Boolean>
}