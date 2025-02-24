package com.example.rememberall.ui.navigation
import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Serializable
object NotesScreen

@Serializable
data class NoteDetailScreen(val id: Int)

@Serializable
object ImageScreen
