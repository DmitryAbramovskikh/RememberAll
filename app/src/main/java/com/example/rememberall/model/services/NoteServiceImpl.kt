package com.example.rememberall.model.services

import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.NoteRepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

// TODO: перенести отсюда любые изменения сущностей, сохраняемая сущность должна генеритоваться в репозитории

class NoteServiceImpl @Inject constructor(private val offline: NoteRepositoryInterface): NoteService {
    override suspend fun fetchAll(): Flow<List<Note>> =
        offline.fetchAll().map { it.map { Note(it) } }

    override suspend fun getById(id: Int): Flow<Note?> =
        offline.getById(id).map { it?.let { Note(it) } }

    override suspend fun save(note: Note) = flow {
        try {
            var noteEntry = note
            if (note.id == -1)
                noteEntry = note.copy(id = null)
            offline.insert(noteEntry)
            emit(true)
        } catch (exception: Exception) {
            emit(false)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun delete(id: Int): Flow<Boolean> = offline.delete(id)
}