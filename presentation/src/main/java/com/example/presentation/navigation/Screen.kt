package com.example.presentation.navigation

sealed class Screen(val route: String) {
    object SearchRepos: Screen(route = "search_repos_screen")
    object RepoInfo: Screen(route = "repo_info_screen/")
}