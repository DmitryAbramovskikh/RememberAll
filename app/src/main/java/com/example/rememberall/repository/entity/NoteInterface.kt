package com.example.rememberall.repository.entity

import java.util.Date

interface NoteInterface
{
    val id: Int
    val created: Date
    val edited: Date
    val text: String
}
