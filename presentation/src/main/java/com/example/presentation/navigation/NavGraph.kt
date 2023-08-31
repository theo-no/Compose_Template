package com.example.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.presentation.ui.screen.RepoInfoScreen
import com.example.presentation.ui.screen.SearchReposScreen


@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SearchRepos.route
    ) {
        composable(
            route = Screen.SearchRepos.route
        ){
            SearchReposScreen(navController = navController)
        }
        composable(
            route = Screen.RepoInfo.route+"{repo}",
            arguments = listOf(navArgument("repo"){
                type = NavType.StringType
            })
        ){
            val repo = it.arguments?.getString("repo")?:""
            RepoInfoScreen(repoName = repo, navController = navController)
        }
    }
} // End of setUpNavGraph