package com.example.rememberall.model.services

import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.NoteRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteServiceImpl @Inject constructor(private val offline: NoteRepositoryInterface): NoteService
{
    override fun fetchAll(): Flow<List<Note>> =
        offline.fetchAll().map { it.map { Note(it) } }

    override fun save(note: Note) = offline.insert(note)

}