package com.example.rememberall.ui.note

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rememberall.ui.components.appbar.AppBarBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailScreen(navController: NavHostController)
{
    val viewModel: NoteDetailViewModel = hiltViewModel()
    val title by remember { mutableStateOf(viewModel.title.value ?: "") }
    var text by remember { viewModel.text }

    Scaffold( topBar = { AppBarBack(title = { Text(text = title) }, navController = navController) }) { paddings ->
        Column(modifier = Modifier.padding(paddings)) {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
@Preview
fun NoteScreenPreview()
{
    NoteDetailScreen(rememberNavController())
}