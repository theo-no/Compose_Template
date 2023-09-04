package com.example.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.presentation.ui.screen.HomeScreen
import com.example.presentation.ui.screen.MainScreen
import com.example.presentation.ui.screen.RepoInfoScreen
import com.example.presentation.ui.screen.SearchReposScreen


@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
//        startDestination = Screen.Home.route,
        startDestination = startDestination,
//        startDestination = Screen.Main.route
    ) {
//        composable(
//            route = Screen.Main.route
//        ){
//            MainScreen(navController = navController)
//        }
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navHostController = navController)
        }
        composable(
            route = Screen.SearchRepos.route
        ){
            SearchReposScreen(navController = navController)
        }
        composable(
            route = Screen.RepoInfo.route+"{user}/{repo}",
            arguments = listOf(navArgument("user"){
                    type = NavType.StringType
                },
                navArgument("repo"){
                    type = NavType.StringType
                }
            )
        ){
            val user = it.arguments?.getString("user")?:""
            val repo = it.arguments?.getString("repo")?:""
            RepoInfoScreen(userName = user, repoName = repo, navController = navController)
        }
    }
} // End of setUpNavGraph