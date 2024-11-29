package com.example.rememberall.repository.room

import com.example.rememberall.model.entity.Note
import com.example.rememberall.model.NoteRepositoryInterface
import com.example.rememberall.repository.entity.NoteInterface
import com.example.rememberall.repository.room.dao.DatabaseDAO
import com.example.rememberall.repository.room.entity.NoteDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryRoom @Inject constructor(databaseDAO: DatabaseDAO): NoteRepositoryInterface
{
    private val noteDAO = databaseDAO.getNoteDAO()

    override fun fetchAll() = noteDAO.fetchAll().flowOn(Dispatchers.IO)

    override fun getById(id: Int) = noteDAO.fetchByIds(intArrayOf(id)).map { (it.firstOrNull()) }

    override fun getByIds(ids: List<Int>) = noteDAO.fetchByIds(ids.toIntArray())

    override fun insert(note: Note) { noteDAO.insert(NoteDB(note)) }

    override fun delete(note: NoteInterface) { noteDAO.delete(note as NoteDB) }
}