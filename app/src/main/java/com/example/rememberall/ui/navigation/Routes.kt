package com.example.rememberall.ui.navigation
import kotlinx.serialization.Serializable

sealed interface AppRoutes
{
    @Serializable
    object MainRoute: AppRoutes

    @Serializable
    object NotesRoute: AppRoutes

    @Serializable
    data class NoteDetailRoute(val id: Int = -1): AppRoutes

    @Serializable
    object ImageRoute: AppRoutes
}

