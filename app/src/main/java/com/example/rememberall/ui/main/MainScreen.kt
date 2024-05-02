package com.example.rememberall.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rememberall.R
import com.example.rememberall.ui.components.TopAppBar
import com.example.rememberall.ui.components.text.SingleLineTextR


@Composable
fun MainScreen()
{
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = stringResource(id = R.string.app_name))

        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.side_space), 0.dp)) {
            SingleLineTextR(text = stringResource(id = R.string.main_notes), color = colorResource(id = R.color.text_medium))
            LazyColumn {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen()
}