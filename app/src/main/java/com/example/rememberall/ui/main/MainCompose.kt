package com.example.rememberall.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.rememberall.ui.notes.CellNote
import com.example.rememberall.ui.notes.NotesViewModel


@Composable
fun MainScreen(
    onClickAddNew: () -> Unit,
    onClickShowDetail: (Int) -> Unit = {},
    onCLickShowImage: () -> Unit = {},
    viewModel: NotesViewModel = hiltViewModel()
)
{
    val notes = viewModel.notes.collectAsStateWithLifecycle(listOf())

    Box(Modifier.fillMaxSize())
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(notes.value)
            {
                CellNote(note = it, onClick = { id -> onClickShowDetail(id) })
            }
        }

        FloatingActionButton(
            onClick = onClickAddNew,
            modifier = Modifier
                .padding(32.dp, 32.dp)
                .align(Alignment.BottomEnd),
        ) {
            Text(text = "Кнопка",
                Modifier
                    .padding(16.dp, 8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen(onClickAddNew = {})
}