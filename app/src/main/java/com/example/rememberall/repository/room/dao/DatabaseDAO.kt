package com.example.rememberall.repository.room.dao

import androidx.room.*
import com.example.rememberall.repository.room.converters.DateConverter
import com.example.rememberall.repository.room.entity.NoteDB

@Database(entities = [NoteDB::class], version = 1)
@TypeConverters(value = [DateConverter::class])
abstract class DatabaseDAO: RoomDatabase()
{
    abstract fun getNoteDAO(): NoteDAO
}