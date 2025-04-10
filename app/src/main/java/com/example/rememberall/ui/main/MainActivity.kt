package com.example.rememberall.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rememberall.ui.navigation.AppNavigationHost
import com.example.rememberall.ui.theme.RememberAllTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RememberAllTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                ) {
                    AppHost(navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHost(navController: NavHostController) {

    AppNavigationHost(
        navController = navController,
        modifier = Modifier
            .fillMaxSize()
    )
}