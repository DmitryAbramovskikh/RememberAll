package com.example.rememberall.ui.note

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteDetailCompose(
    id: Int = -1,
    modifier: Modifier = Modifier
)
{
    val viewModel: NoteDetailViewModel = hiltViewModel()
    val title by viewModel.title.observeAsState()

    Text(
        text = title ?: "",
        modifier = Modifier.fillMaxWidth().padding(4.dp, 16.dp)
    )
}

@Composable
@Preview
fun NoteScreenPreview()
{
    NoteDetailCompose()
}