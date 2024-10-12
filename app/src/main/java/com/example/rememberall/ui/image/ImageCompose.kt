package com.example.rememberall.ui.image

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCompose()
{
    val viewModel: ImageViewModel = hiltViewModel()
    val title by remember { viewModel.title }


}