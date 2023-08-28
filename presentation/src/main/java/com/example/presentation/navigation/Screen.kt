package com.example.presentation.navigation

sealed class Screen(val route: String) {
    object Example: Screen(route = "example_screen")
}