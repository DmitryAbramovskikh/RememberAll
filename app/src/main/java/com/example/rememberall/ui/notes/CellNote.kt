package com.example.rememberall.ui.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.rememberall.R
import com.example.rememberall.ui.theme.md_theme_light_onSurfaceVariant
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

        ConstraintLayout(
            modifier = modifier.fillMaxWidth()
        ) {

            val (column, icon, text) = createRefs()

            Column(modifier = Modifier.constrainAs(column) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
                .padding(8.dp)) {
                Text(
                    text = note.title,
                    fontSize = titleFontSize,
                    color = Color.Black
                )

                Text(
                    text = note.text,
                    maxLines = 3,
                    fontSize = contentFontSize,
                    color = Color.DarkGray
                )
            }

            Text(
                text = note.lastUpdateText,
                fontSize = dateFontSize,
                modifier = modifier
                    .constrainAs(text) {
                        end.linkTo(parent.end, margin = 8.dp)
                        bottom.linkTo(parent.bottom, margin = 8.dp)
                    }
                    .padding(8.dp, 0.dp),
                color = Color.LightGray)

            Icon(
                painter = painterResource(R.drawable.baseline_delete_forever_24),
                contentDescription = "Delete",
                tint = md_theme_light_onSurfaceVariant,
                modifier = Modifier
                    .constrainAs(icon) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .padding(8.dp, 8.dp)
                    .clickable { note.id?.let { onDelete(it) } }

            )

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