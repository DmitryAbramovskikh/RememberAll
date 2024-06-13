package com.example.rememberall.ui.local

import java.text.SimpleDateFormat
import java.util.Date

private val DATE_FMT = SimpleDateFormat("dd.MM.yyyy")

fun Date.toReadableDate(): String = DATE_FMT.format(this)