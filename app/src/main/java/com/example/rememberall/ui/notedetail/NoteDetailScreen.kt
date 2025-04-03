package com.example.rememberall.ui.notedetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoteDetailScreen(state: NoteDetailContract.State,
                     intentListener: (NoteDetailContract.Intent) -> Unit,
                     effectListener: (NoteDetailContract.Effect) -> Unit)
{
    Box() {
        Column(modifier = Modifier) {
            OutlinedTextField(
                value = state.title,
                onValueChange = { intentListener(NoteDetailContract.Intent.ChangeTitle(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(4.dp, 16.dp)
            )

            val textPaddingBottom = if (!state.isChanged) 16.dp else 64.dp

            OutlinedTextField(
                value = state.text,
                onValueChange = { intentListener(NoteDetailContract.Intent.ChangeText(it)) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp, 0.dp, 4.dp, textPaddingBottom)
            )
        }

        if (state.isChanged) {
            Button(
                onClick = { intentListener(NoteDetailContract.Intent.Save) },
                modifier = Modifier
                    .padding(16.dp, 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomCenter)
            ) {
                Text("Coхранить")
            }
        }
    }
}

@Preview
@Composable
fun PreviewNoteDetailCompose()
{
    NoteDetailScreen (NoteDetailContract.State(), {}, {})
}