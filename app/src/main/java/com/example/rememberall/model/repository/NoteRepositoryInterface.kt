package com.example.rememberall.model.repository

import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.repository.entity.NoteInterface
import kotlinx.coroutines.flow.Flow

interface NoteRepositoryInterface
{
    fun fetchAll(): Flow<List<NoteInterface>>

    fun getById(id: Int): Flow<NoteInterface?>

    fun getByIds(ids: List<Int>): Flow<List<NoteInterface>>

    suspend fun insert(note: Note)
}