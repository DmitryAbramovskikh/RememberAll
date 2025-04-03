package com.example.rememberall.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.rememberall.R
import com.example.rememberall.ui.components.appbar.AppBarBack
import com.example.rememberall.ui.image.ImageCompose
import com.example.rememberall.ui.main.MainBottomBar
import com.example.rememberall.ui.navigation.destinations.MainDestination
import com.example.rememberall.ui.navigation.destinations.NoteDetailDestination
import com.example.rememberall.ui.navigation.destinations.NoteDestination

class ScaffoldState(val title: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigationHost(navController: NavHostController, modifier: Modifier = Modifier)
{
    var scaffoldState by remember { mutableStateOf(ScaffoldState("App")) }

    val buttonVisible = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            AppBarBack(
                title = scaffoldState.title,
                navController = navController,
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier,
                navController = navController,
                state = buttonVisible)
        },
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .background(Color.White)
    ) { padding ->
        NavHost(navController = navController, startDestination = MainRoute, modifier = modifier.padding(padding)) {

            composable<MainRoute> {
                scaffoldState = ScaffoldState(stringResource(R.string.main_notes))
                MainDestination(navController)
            }

            composable<NotesRoute> {
                scaffoldState = ScaffoldState(stringResource(R.string.notes_title))
                NoteDestination(navController)
            }

            composable<NoteDetailRoute> { backStackEntry ->
                scaffoldState = ScaffoldState(stringResource(R.string.note_detail_title))
                val noteDetailScreen = backStackEntry.toRoute<NoteDetailRoute>()

                NoteDetailDestination(navController, noteDetailScreen.id)
            }

            composable<ImageRoute>{
                ImageCompose()
            }
        }
    }

}