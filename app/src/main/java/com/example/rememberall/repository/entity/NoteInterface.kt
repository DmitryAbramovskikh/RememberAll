package com.example.rememberall.repository.entity

import java.util.Date

interface NoteInterface
{
    val id: Int?
    val title: String
    val text: String
    val created: Date
    val edited: Date
}
