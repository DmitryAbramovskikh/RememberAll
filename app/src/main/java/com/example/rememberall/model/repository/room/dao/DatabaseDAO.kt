package com.example.rememberall.model.repository.room.dao

import androidx.room.*
import com.example.rememberall.model.repository.room.converters.DateConverter
import com.example.rememberall.model.repository.room.entity.NoteDB

@Database(entities = [NoteDB::class], version = 1)
@TypeConverters(value = [DateConverter::class])
abstract class DatabaseDAO: RoomDatabase()
{
    abstract fun getNoteDAO(): NoteDAO
}