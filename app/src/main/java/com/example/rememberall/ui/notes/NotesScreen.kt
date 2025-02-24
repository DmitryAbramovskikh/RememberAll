package com.example.rememberall.ui.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.rememberall.ui.theme.md_theme_light_onPrimaryContainer
import com.example.rememberall.ui.theme.md_theme_light_onTertiaryContainer
import com.example.rememberall.ui.theme.md_theme_light_tertiaryContainer

@Composable
fun NotesScreen(
    onClickAddNew: () -> Unit,
    onClickShowDetail: (Int) -> Unit = {},
    viewModel: NotesViewModel = hiltViewModel()
) {
    val notes by viewModel.notes.collectAsStateWithLifecycle(listOf())

    Box(Modifier
        .fillMaxSize())
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 8.dp)
        ) {
            items(notes)
            {
                CellNoteComposable(note = it, onClick = { id -> onClickShowDetail(id) }, onDelete = { id -> viewModel.onDelete(id) })
            }
        }

        FloatingActionButton(
            onClick = onClickAddNew,
            modifier = Modifier
                .padding(32.dp, 32.dp)
                .align(Alignment.BottomEnd),
            containerColor = md_theme_light_tertiaryContainer
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                modifier = Modifier,
                tint = md_theme_light_onTertiaryContainer)
        }
    }
}