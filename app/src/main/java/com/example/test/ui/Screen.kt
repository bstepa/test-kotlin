package com.example.test.ui

import androidx.navigation.compose.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object Test : Screen("test", emptyList())
}