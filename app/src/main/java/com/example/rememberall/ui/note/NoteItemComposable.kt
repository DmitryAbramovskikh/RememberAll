package com.example.rememberall.ui.note

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rememberall.R
import com.example.rememberall.ui.components.text.SingleLineTextS
import com.example.rememberall.ui.notes.NoteVM

@Composable
fun NoteItemComposable(note: NoteVM)
{
    val shape = RoundedCornerShape(dimensionResource(id = R.dimen.side_space_half))
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(colorResource(id = R.color.secondaryLight), shape = shape)
        .border(1.dp, colorResource(id = R.color.secondary), shape = shape)
        .clickable { note.onCLick() }
        .padding(dimensionResource(R.dimen.side_space), dimensionResource(id = R.dimen.side_space_half))
    ) {
        SingleLineTextS(text = note.text)
    }
}


@Preview(showBackground = true)
@Composable
private fun NoteItemComposablePreview()
{
    NoteItemComposable(note = NoteVM(-1, "22.10.24", "23.10.24", "Some title\nSome Text"))
}