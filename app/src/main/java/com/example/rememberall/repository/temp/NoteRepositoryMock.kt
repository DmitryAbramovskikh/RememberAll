package com.example.rememberall.repository.temp

import android.util.Log
import com.example.rememberall.model.NoteRepositoryInterface
import com.example.rememberall.model.entity.Note
import com.example.rememberall.repository.entity.NoteInterface
import com.example.rememberall.repository.room.entity.NoteDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.Date

object NoteRepositoryMock: NoteRepositoryInterface
{
    override fun fetchAll(): Flow<List<NoteInterface>> =
        flow<List<NoteInterface>> {
            emit(notes)
        }

    override fun getById(id: Int): Flow<NoteInterface?> =
        flow {
            val note = notes.firstOrNull { it.id == id }
            note?.let { emit(it) }
        }

    override fun getByIds(ids: List<Int>): Flow<List<NoteInterface>> =
        flow {
            val notesF = notes.filter { it.id in ids }
            emit(notesF)
        }

    override fun insert(note: Note)
    {
        Log.d("SIMPLETAG", "inserted title: ${note.title}")
        if (notes.firstOrNull { it.id == note.id } != null)
            notes.removeIf { it.id == note.id }
        notes.add(NoteDB(note))
    }


    private val notes = mutableListOf(
        NoteDB(0, "Оценки", "Оценки в наше веремя очень важны.", Date(Date().time - 10000000L), Date()),
        NoteDB(1, "Полномочия", "Полномочия в наше веремя очень важны.", Date(Date().time - 10000000L), Date()),
        NoteDB(2, "Критерии", "Критерии в наше веремя очень важны.", Date(Date().time - 10000000L), Date()),
        NoteDB(3, "Методы", "Методы в наше веремя очень важны.", Date(Date().time - 10000000L), Date()),
    )
}