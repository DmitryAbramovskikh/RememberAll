package com.example.rememberall.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

private val MAIN_SCREEN_EFFECT_KEY = "main_screen_effect_key"

@Composable
fun MainDestination(navController: NavHostController) {
    val viewModel: MainViewModel = hiltViewModel()

    LaunchedEffect(MAIN_SCREEN_EFFECT_KEY) {
        viewModel.effect.collect {
            when(it)
            {
                else -> {}
            }
        }
    }

    val effectListener: (MainContract.Effect) -> Unit = { effect -> viewModel.setEffect(effect) }
    val intentListener: (MainContract.Intent) -> Unit = { intent -> viewModel.setIntent(intent) }

    MainScreen(viewModel.state.value, effectListener, intentListener)
}