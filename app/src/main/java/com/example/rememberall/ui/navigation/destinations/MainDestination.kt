package com.example.rememberall.ui.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rememberall.ui.base.components.BaseDestination
import com.example.rememberall.ui.main.MainContract
import com.example.rememberall.ui.main.MainScreen
import com.example.rememberall.ui.main.MainViewModel
import com.example.rememberall.ui.navigation.AppRoutes

private val MAIN_SCREEN_EFFECT_KEY = "main_screen_effect_key"

@Composable
fun MainDestination(navController: NavHostController) =
    BaseDestination<MainContract.State, MainContract.Effect, MainContract.Intent, MainViewModel> { state, effect, effectListener, intentListener ->

        LaunchedEffect(MAIN_SCREEN_EFFECT_KEY) {
            effect.collect {
                when(it)
                {
                    is MainContract.Effect.AddDaily -> navController.navigate(AppRoutes.NoteDetailRoute())
                    else -> {}
                }
            }
        }

        MainScreen(state, effectListener, intentListener)
    }