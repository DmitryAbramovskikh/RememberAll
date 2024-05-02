package com.example.rememberall.model.entity

import java.util.Date

data class Note(val id: Int,
           val created: Date,
           val edited: Date,
           val text: String)