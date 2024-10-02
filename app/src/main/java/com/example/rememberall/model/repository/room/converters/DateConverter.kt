package com.example.rememberall.model.repository.room.converters

import androidx.room.TypeConverter
import java.util.Date

class DateConverter
{
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time?.toLong()
}