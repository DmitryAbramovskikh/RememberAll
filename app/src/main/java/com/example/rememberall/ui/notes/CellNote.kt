package com.example.rememberall.ui.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rememberall.R

@Composable
fun CellNote(
    note: NoteVM,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(colorResource(id = R.color.secondaryLight))
            .fillMaxWidth()
            .padding(16.dp, 8.dp)
            .clickable { onClick(note.id) }
    ) {
        Text(
            text = note.title,

        )
        Text( text = note.text )
        Text( text = note.created )
        Text( text = note.edited )
    }
}

@Preview
@Composable
fun CellNotePreview() {
    CellNote(
        NoteVM(12, "Заметка", "Содержание заметки", "12.10.2023", "10.09.2024"),
        { }
    )
}