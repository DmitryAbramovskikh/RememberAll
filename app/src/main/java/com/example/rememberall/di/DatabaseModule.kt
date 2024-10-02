package com.example.rememberall.di

import android.content.Context
import androidx.room.Room
import com.example.rememberall.model.repository.room.dao.DatabaseDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule
{
    @Provides
    @Singleton
    fun provideDatabaseDAO(context: Context): DatabaseDAO =
        Room
        .databaseBuilder(context, DatabaseDAO::class.java, "Database.sqlite")
        .fallbackToDestructiveMigration()
        .build()
}