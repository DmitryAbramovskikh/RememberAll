package com.example.rememberall.di

import com.example.rememberall.model.repository.NoteRepositoryInterface
import com.example.rememberall.model.repository.room.NoteRepositoryRoom
import com.example.rememberall.model.repository.room.dao.DatabaseDAO
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