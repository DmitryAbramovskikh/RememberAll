package com.example.rememberall.ui.navigation
import kotlinx.serialization.Serializable

@Serializable
object MainRoute

@Serializable
object NotesRoute

@Serializable
data class NoteDetailRoute(val id: Int = -1)

@Serializable
object ImageRoute
