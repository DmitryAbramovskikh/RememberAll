package com.example.rememberall.ui.notes

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rememberall.R
import com.example.rememberall.ui.components.text.*

@Composable
fun NoteItemComposable(note: NoteVM)
{
    val shape = RoundedCornerShape(dimensionResource(id = R.dimen.side_space_half))
    Row(modifier = Modifier
        .padding(vertical = 4.dp)
        .fillMaxWidth()
        .background(colorResource(id = R.color.secondaryLight), shape = shape)
        .border(1.dp, colorResource(id = R.color.secondary), shape = shape)
        .clickable { note.onCLick() }
        .padding(dimensionResource(R.dimen.side_space), dimensionResource(id = R.dimen.side_space_half))
    ) {
        Column {
            SingleLineTextS(text = note.text, fontSize = 16.sp)
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End) {
                SingleLineTextR(
                    text = stringResource(id = R.string.note_detail_created_lab),
                    color = colorResource(id = R.color.text_medium_light))
                Spacer(modifier = Modifier.size(8.dp))
                SingleLineTextR(
                    text = note.created,
                    color = colorResource(id = R.color.text_medium_light))
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End) {
                SingleLineTextR(
                    text = stringResource(id = R.string.note_detail_edited_lab),
                    color = colorResource(id = R.color.text_medium_light))
                Spacer(modifier = Modifier.size(8.dp))
                SingleLineTextR(
                    text = note.edited,
                    color = colorResource(id = R.color.text_medium_light))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteItemComposablePreview()
{
    NoteItemComposable(note = NoteVM(-1, "22.10.24", "23.10.24", "Some title\nSome Text"))
}