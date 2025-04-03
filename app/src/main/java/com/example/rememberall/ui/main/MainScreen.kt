package com.example.rememberall.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rememberall.ui.main.components.AddDailyComponent
import com.example.rememberall.ui.notes.NotesContract


@Composable
fun MainScreen(state: MainContract.State,
               effectListener: (MainContract.Effect) -> Unit,
               intentListener: (MainContract.Intent) -> Unit)
{
    Column {
        AddDailyComponent(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            onClick = { effectListener(MainContract.Effect.AddDaily) })
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen(MainContract.State(false), {}, {})
}