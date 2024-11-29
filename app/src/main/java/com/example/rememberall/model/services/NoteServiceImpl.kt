package com.example.rememberall.model.services

import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.NoteRepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// TODO: перенести отсюда любые изменения сущностей, сохраняемая сущность должна генеритоваться в репозитории

class NoteServiceImpl @Inject constructor(private val offline: NoteRepositoryInterface): NoteService
{
    override fun fetchAll(): Flow<List<Note>> =
        offline.fetchAll().map { it.map { Note(it) } }

    override fun getById(id: Int): Flow<Note?> =
        offline.getById(id).map { it?.let { Note(it) } }

    override fun save(note: Note) = flow {
        try {
            var noteEntry = note
            if (note.id == -1)
                noteEntry = note.copy(id = null)
            offline.insert(noteEntry)
            emit(true)
        }
        catch(exception: Exception) {
            emit(false)
        }
    }.flowOn(Dispatchers.IO)

    // TODO: эта бабуйня тоже должна быть в репозитории
    override fun delete(id: Int): Flow<Boolean> = flow {
        offline.getById(id)
            .map { it?.let { offline.delete(it) } }
            .collect()

        emit(true)
    }.flowOn(Dispatchers.IO)
}