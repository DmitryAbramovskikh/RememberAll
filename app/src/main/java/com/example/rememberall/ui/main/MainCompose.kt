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
import com.example.rememberall.ui.notes.CellNoteComposable
import com.example.rememberall.ui.notes.NotesViewModel


@Composable
fun MainScreen(
    onCLickShowImage: () -> Unit = {}
)
{

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen()
}