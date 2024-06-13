package com.example.rememberall.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rememberall.R
import com.example.rememberall.ui.components.text.SingleLineTextS

@Composable
fun TopAppBar(title: String)
{
    Row(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.side_space), 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SingleLineTextS(text = title.uppercase())
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview()
{
    TopAppBar(title = "Preview")
}