package com.example.rememberall.di

import com.example.rememberall.model.repository.NoteRepositoryInterface
import com.example.rememberall.model.services.NoteService
import com.example.rememberall.model.services.NoteServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule
{
    @Singleton
    @Provides
    fun provideNoteService(offline: NoteRepositoryInterface): NoteService = NoteServiceImpl(offline)
}