package com.example.rememberall.repository.room.dao

import androidx.room.*
import com.example.rememberall.repository.room.entity.NOTES_TABLE
import com.example.rememberall.repository.room.entity.NoteDB
import kotlinx.coroutines.flow.Flow

@Dao
abstract class NoteDAO
{
    @Query("SELECT * from $NOTES_TABLE")
    abstract fun fetchAll(): Flow<List<NoteDB>>

    @Query("SELECT * FROM $NOTES_TABLE WHERE id IN (:ids)")
    abstract  fun fetchByIds(ids: IntArray): Flow<List<NoteDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entity: NoteDB)

    @Delete
    abstract fun delete(entity: NoteDB)
}