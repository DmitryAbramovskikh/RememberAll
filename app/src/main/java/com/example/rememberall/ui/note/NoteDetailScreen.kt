package com.example.rememberall.ui.note

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rememberall.R

@Composable
fun NoteDetailScreen(navController: NavHostController)
{
    val viewModel: NoteDetailViewModel = viewModel()
    val text = mutableStateOf(viewModel.text.value ?: "")
        Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.white)
    ) {
        Text(text = text.value)
    }
}

@Composable
@Preview
fun NoteScreenPreview()
{
    NoteDetailScreen(rememberNavController())
}