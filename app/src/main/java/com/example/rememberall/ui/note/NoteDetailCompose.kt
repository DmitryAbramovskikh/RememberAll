package com.example.rememberall.ui.note

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun NoteDetailCompose(
    viewModel: NoteDetailViewModel,
    onSaveNote: () -> Unit = { },
    modifier: Modifier = Modifier
)
{
    Column(modifier = modifier) {
        OutlinedTextField(
            value = viewModel.title,
            onValueChange = { viewModel.onNoteEdit(title = it) },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(4.dp, 16.dp)
        )

        OutlinedTextField(
            value = viewModel.text,
            onValueChange = { viewModel.onNoteEdit(text = it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp, 16.dp)
        )

        if (viewModel.isChanged) {
            Button(
                onClick = {
                    viewModel.onSave()
                    onSaveNote()
                },
                modifier = Modifier
                    .padding(16.dp, 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text("Coхранить")
            }
        }
    }

}
