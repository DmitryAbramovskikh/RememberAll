package com.example.rememberall.repository.room.dao

import androidx.room.*
import com.example.rememberall.repository.room.entity.NOTES_TABLE
import com.example.rememberall.repository.room.entity.NoteDB
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO
{
    @Query("SELECT * from $NOTES_TABLE")
    fun fetchAll(): Flow<List<NoteDB>>

    @Query("SELECT * FROM $NOTES_TABLE WHERE id IN (:ids)")
    fun fetchByIds(ids: IntArray): Flow<List<NoteDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: NoteDB)

    @Update
    fun update(entity: NoteDB)

    @Query("DELETE FROM $NOTES_TABLE WHERE id=:id")
    suspend fun delete(id: Int)
}