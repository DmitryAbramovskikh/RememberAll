package com.example.rememberall.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rememberall.ui.navigation.AppNavigationGraph
import com.example.rememberall.ui.theme.RememberAllTheme

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
                    AppEntryPoint(navController)
                }
            }
        }
    }
}

@Composable
fun AppEntryPoint(navController: NavHostController) {
    AppNavigationGraph(navController)
}