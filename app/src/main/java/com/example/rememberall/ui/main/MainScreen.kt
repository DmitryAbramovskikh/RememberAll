package com.example.rememberall.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rememberall.R
import com.example.rememberall.ui.components.TopAppBar
import com.example.rememberall.ui.components.text.SingleLineTextR
import com.example.rememberall.ui.navigation.Routes


@Composable
fun MainScreen(navController: NavController)
{
    Box()
    {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = stringResource(id = R.string.app_name))

            Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.side_space), 0.dp)) {
                SingleLineTextR(text = stringResource(id = R.string.main_notes), color = colorResource(id = R.color.text_medium))
                LazyColumn {

                }
                Button(onClick = { navController.navigate(Routes.NOTE_DETAIL_SCREEN) }) {
                    Text(text = "Show")
                }
            }
        }
        FloatingActionButton(
            onClick = { navController.navigate(Routes.NOTE_DETAIL_SCREEN) },
            contentColor = colorResource(id = R.color.primary),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp, 16.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_plus_fab), contentDescription = "")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview()
{
    MainScreen(rememberNavController())
}