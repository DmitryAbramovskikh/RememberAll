package com.example.rememberall.ui.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rememberall.R
import java.util.Date

@Composable
fun CellNoteComposable(
    note: NoteVM,
    onClick: (Int) -> Unit,
    onDelete: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 4.dp)
            .clickable {
                if (note.id != null)
                    onClick(note.id)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            disabledContainerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        val dateFontSize by remember { mutableStateOf(11.sp) }
        val titleFontSize by remember { mutableStateOf(14.sp) }
        val contentFontSize by remember { mutableStateOf(13.sp) }
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = note.title,
                fontSize = titleFontSize,
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
        Button(onClick = { note.id?.let { onDelete(it) } }, modifier = Modifier.padding(8.dp).align(Alignment.End)) {
            Icon(painter = painterResource(R.drawable.baseline_delete_forever_24), contentDescription = "Delete", tint = Color.White)
        }
    }
}

@Preview
@Composable
fun CellNotePreview() {
    CellNoteComposable(
        NoteVM(12, "Заметка", "Содержание заметки", Date(), Date()),
        { },
        { }
    )
}