package com.example.rememberall.model.repository.room

import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.repository.NoteRepositoryInterface
import com.example.rememberall.model.repository.entity.NoteInterface
import com.example.rememberall.model.repository.room.dao.DatabaseDAO
import com.example.rememberall.model.repository.room.entity.NoteDB
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryRoom @Inject constructor(databaseDAO: DatabaseDAO): NoteRepositoryInterface
{
    private val noteDAO = databaseDAO.getNoteDAO()

    override fun fetchAll() = noteDAO.fetchAll()

    override fun getById(id: Int) = noteDAO.fetchByIds(intArrayOf(id)).map { (it.firstOrNull()) }

    override fun getByIds(ids: List<Int>) = noteDAO.fetchByIds(ids.toIntArray())

    override suspend fun insert(note: Note) = noteDAO.insert(NoteDB(note))
}