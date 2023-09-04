package com.example.presentation.navigation

import androidx.compose.material.icons.Icons

sealed class Screen(val name: String, val route: String) {
    object Main: Screen(
        name = "Main",
        route = "main_screen"
    )
    object Home: Screen(
        name = "Home",
        route = "home_screen"
    )
    object SearchRepos: Screen(
        name = "SearchRepos",
        route = "search_repos_screen"
    )
    object RepoInfo: Screen(
        name = "RepoInfo",
        route = "repo_info_screen/"
    )
}