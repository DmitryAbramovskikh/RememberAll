package com.example.rememberall.ui.note

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rememberall.ui.base.StringProvider

@Composable
fun NoteDetailCompose(
    viewModel: NoteDetailViewModel,
    modifier: Modifier = Modifier
)
{
    val title by remember { viewModel.title }

    OutlinedTextField(
        value = title,
        onValueChange = { viewModel.title.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp, 16.dp)
    )
}

@Composable
@Preview
fun NoteScreenPreview()
{
    NoteDetailCompose(
        NoteDetailViewModel(
            stringProvider = object: StringProvider {
                override fun getString(id: Int): String = ""
            },
            id = -1
        )
    )
}
