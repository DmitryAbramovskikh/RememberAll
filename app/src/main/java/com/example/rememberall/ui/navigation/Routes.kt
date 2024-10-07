package com.example.rememberall.ui.navigation

import kotlinx.serialization.Serializable

object Routes
{
    val MAIN_SCREEN = "main_screen"
    val NOTE_DETAIL_SCREEN = "note_detail_screen"
    val IMAGE_SCREEN = "image_screen"
}

@Serializable
object MainScreen

@Serializable
data class NoteDetailScreen(val id: Int)

@Serializable
object ImageScreen
