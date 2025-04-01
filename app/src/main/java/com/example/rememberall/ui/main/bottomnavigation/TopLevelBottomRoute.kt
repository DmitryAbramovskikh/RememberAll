package com.example.rememberall.ui.main.bottomnavigation

import androidx.compose.ui.graphics.vector.ImageVector

data class TopLevelBottomRoute<T: Any>(val name: String, val route: T, val routeName: String, val icon: ImageVector)
