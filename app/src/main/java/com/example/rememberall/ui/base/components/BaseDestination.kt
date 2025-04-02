package com.example.rememberall.ui.base.components

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rememberall.ui.base.BaseContract
import com.example.rememberall.ui.base.BaseViewModel
import com.example.rememberall.ui.theme.md_theme_light_error
import com.example.rememberall.ui.theme.md_theme_light_errorContainer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
inline fun <S: BaseContract.ViewUIState, E: BaseContract.ViewSideEffect, I: BaseContract.ViewIntent, reified VM: BaseViewModel<S,I,E>>
        BaseDestination(content: @Composable (S, Flow<E>, (E) -> Unit, (I) -> Unit) -> Unit)
{
    val viewModel: VM = hiltViewModel()
    val snackBarHostState = remember { SnackbarHostState() }

    val effectListener: (E) -> Unit = { effect -> viewModel.setEffect(effect) }
    val intentListener: (I) -> Unit = { intent -> viewModel.setIntent(intent) }

    content.invoke(viewModel.state.value, viewModel.effect, effectListener, intentListener)

    LaunchedEffect(true) {
        viewModel.error.collect {
            if (it.message.isNotEmpty())
                snackBarHostState.showSnackbar(it.message)
        }
    }
    SnackbarErrorHost(snackBarHostState)
}

@Composable
fun SnackbarErrorHost(hostState: SnackbarHostState) {
    SnackbarHost(hostState = hostState) {
        Snackbar(
            modifier = Modifier,
            snackbarData = it,
            containerColor = md_theme_light_errorContainer,
            contentColor = md_theme_light_error
        )
    }
}