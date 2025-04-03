package com.example.rememberall.ui.base.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rememberall.ui.base.BaseContract
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.theme.md_theme_light_error
import com.example.rememberall.ui.theme.md_theme_light_errorContainer
import kotlinx.coroutines.flow.Flow

@Composable
inline fun <S: BaseContract.ViewUIState, E: BaseContract.ViewSideEffect, I: BaseContract.ViewIntent, reified VM: BaseViewModel<S,I,E>>
        BaseDestination(content: @Composable (S, Flow<E>, (E) -> Unit, (I) -> Unit) -> Unit)
{
    val viewModel: VM = hiltViewModel()
    BaseDestination<S, E, I, VM>(viewModel, content)
}

@Composable
inline fun <S: BaseContract.ViewUIState, E: BaseContract.ViewSideEffect, I: BaseContract.ViewIntent, reified VM: BaseViewModel<S,I,E>>
        BaseDestination(viewModel: VM, content: @Composable (S, Flow<E>, (E) -> Unit, (I) -> Unit) -> Unit)
{
    val snackBarHostState = remember { SnackbarHostState() }

    val effectListener: (E) -> Unit = { effect -> viewModel.setEffect(effect) }
    val intentListener: (I) -> Unit = { intent -> viewModel.setIntent(intent) }

    LaunchedEffect(true) {
        viewModel.error.collect {
            if (it.message.isNotEmpty())
                snackBarHostState.showSnackbar(it.message)
        }
    }

    content.invoke(viewModel.state.value, viewModel.effect, effectListener, intentListener)

    SnackbarErrorHost(snackBarHostState)
}

@Composable
fun SnackbarErrorHost(hostState: SnackbarHostState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
        SnackbarHost(hostState = hostState) {
            Snackbar(
                snackbarData = it,
                containerColor = md_theme_light_errorContainer,
                contentColor = md_theme_light_error
            )
        }
    }
}