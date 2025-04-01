package com.example.rememberall.ui.main

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rememberall.ui.notes.NotesContract


@Composable
fun MainScreen(state: MainContract.State,
               effectListener: (MainContract.Effect) -> Unit,
               intentListener: (MainContract.Intent) -> Unit)
{

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen(MainContract.State(false), {}, {})
}