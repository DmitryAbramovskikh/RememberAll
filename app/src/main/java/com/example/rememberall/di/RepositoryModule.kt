package com.example.rememberall.di

import com.example.rememberall.model.NoteRepositoryInterface
import com.example.rememberall.repository.room.dao.DatabaseDAO
import com.example.rememberall.repository.mockrepos.NoteRepositoryMock
import com.example.rememberall.repository.room.NoteRepositoryRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule
{
    @Singleton
    @Provides
    fun provideNoteRepository(databaseDAO: DatabaseDAO): NoteRepositoryInterface = NoteRepositoryRoom(databaseDAO)
}