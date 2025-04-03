package com.example.rememberall.ui.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rememberall.R
import java.nio.file.WatchEvent

@Composable
fun AddDailyComponent(modifier: Modifier, onClick: () -> Unit)
{
    Card(modifier = modifier, onClick = onClick) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(R.drawable.ic_plus_fab),
                contentDescription = null)

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(R.string.main_add_daily_note),
                textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun AddDailyComponentPreview()
{
    AddDailyComponent(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), onClick = {})
}