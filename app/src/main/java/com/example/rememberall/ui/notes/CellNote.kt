package com.example.rememberall.ui.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Date

@Composable
fun CellNoteComposable(
    note: NoteVM,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 4.dp)
            .clickable { onClick(note.id) },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            disabledContainerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        val dateFontSize by remember { mutableStateOf(11.sp) }
        val contentFontSize by remember { mutableStateOf(13.sp) }
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = note.title,
                fontSize = contentFontSize,
                color = Color.Black
            )
            Text(
                text = note.text,
                fontSize = contentFontSize,
                color = Color.DarkGray
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Right) {
                Text( text = note.createdText, fontSize = dateFontSize, color = Color.LightGray )
                Text( text = note.editedText, fontSize = dateFontSize, modifier = modifier.padding(8.dp, 0.dp), color = Color.LightGray )
            }

        }
    }
}

@Preview
@Composable
fun CellNotePreview() {
    CellNoteComposable(
        NoteVM(12, "Заметка", "Содержание заметки", Date(), Date()),
        { }
    )
}