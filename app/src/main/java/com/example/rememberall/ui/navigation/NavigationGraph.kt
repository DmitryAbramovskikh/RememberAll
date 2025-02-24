package com.example.rememberall.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.rememberall.R
import com.example.rememberall.ui.components.appbar.AppBarBack
import com.example.rememberall.ui.image.ImageCompose
import com.example.rememberall.ui.main.MainBottomBar
import com.example.rememberall.ui.main.MainScreen
import com.example.rememberall.ui.note.NoteDetailCompose
import com.example.rememberall.ui.note.NoteDetailViewModel
import com.example.rememberall.ui.notes.NotesScreen

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
        NavHost(navController = navController, startDestination = MainScreen, modifier = modifier.padding(padding)) {

            composable<MainScreen>(
            ) {
                scaffoldState = ScaffoldState(stringResource(R.string.main_notes))
                MainScreen( )
            }

            composable<NotesScreen> {
                scaffoldState = ScaffoldState(stringResource(R.string.notes_title))
                NotesScreen(
                    onClickAddNew = { navController.navigate(NoteDetailScreen(-1)) },
                    onClickShowDetail = { navController.navigate(NoteDetailScreen(it)) }
                )
            }

            composable<NoteDetailScreen> { backStackEntry ->
                scaffoldState = ScaffoldState(stringResource(R.string.note_detail_title))
                val noteDetailScreen = backStackEntry.toRoute<NoteDetailScreen>()
                val noteViewModel = hiltViewModel<NoteDetailViewModel, NoteDetailViewModel.Factory> {
                    it.create(noteDetailScreen.id)
                }
                NoteDetailCompose(noteViewModel, onSaveNote = { navController.navigateUp() })
            }

            composable<ImageScreen>{
                ImageCompose()
            }
        }
    }

}