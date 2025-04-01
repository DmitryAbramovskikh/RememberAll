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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rememberall.ui.base.components.LoadingFullscreenIndicator
import com.example.rememberall.ui.theme.md_theme_light_onTertiaryContainer
import com.example.rememberall.ui.theme.md_theme_light_tertiaryContainer

@Composable
fun NotesScreen(
    state: NotesContract.ViewState,
    effectListener: (NotesContract.Effect) -> Unit,
    intentListener: (NotesContract.Intent) -> Unit
) {
    when {
        state.isLoading == true -> { LoadingFullscreenIndicator() }
        state.notes.isNotEmpty() -> { NotesList(intentListener, effectListener, state.notes) }
        else -> { NotesEmptyList(effectListener) }
    }
}

@Composable
private fun NotesList(intentListener: (NotesContract.Intent) -> Unit,
                      effectListener: (NotesContract.Effect) -> Unit,
                      notes: List<NoteVM>)
{
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
                CellNoteComposable(
                    note = it,
                    onClick = { id -> effectListener(NotesContract.Effect.ShowDetail(id)) },
                    onDelete = { id -> intentListener(NotesContract.Intent.Delete(id)) })
            }
        }

        AddNewButton(modifier = Modifier.align(Alignment.BottomEnd), effectListener)
    }
}

@Composable
private fun NotesEmptyList(effectListener: (NotesContract.Effect) -> Unit)
{
    Box()
    {
        AddNewButton(modifier = Modifier.align(Alignment.BottomEnd), effectListener)
    }
}

@Composable
private fun AddNewButton(modifier: Modifier,
                         effectListener: (NotesContract.Effect) -> Unit)
{
    FloatingActionButton(
        onClick = { effectListener(NotesContract.Effect.AddNew) },
        modifier = modifier.padding(32.dp, 32.dp),
        containerColor = md_theme_light_tertiaryContainer
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "",
            modifier = Modifier,
            tint = md_theme_light_onTertiaryContainer)
    }
}