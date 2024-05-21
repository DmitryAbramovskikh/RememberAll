package com.example.rememberall.di

import android.content.Context
import com.example.rememberall.ui.base.StringProvider
import com.example.rememberall.ui.base.StringProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainComponent
{
    @Provides
    @Singleton
    fun provideStringProvider(@ApplicationContext context: Context): StringProvider = StringProviderImpl(context)
}