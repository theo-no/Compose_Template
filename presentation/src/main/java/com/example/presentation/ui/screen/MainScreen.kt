package com.example.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.presentation.navigation.BottomNavItem
import com.example.presentation.navigation.NavGraph
import com.example.presentation.navigation.Screen


private const val TAG = "MainScreen 차선호"
var startDestination: String = Screen.Home.route //나중에 viewModel로 빼야함
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController
){

    Scaffold(
        topBar = {
            MainHeader(navController = navController)
        },
        bottomBar = {
            MainBottomNavigationBar(navController = navController)
        },
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {
            Log.d(TAG, "NavGraph 호출")
            NavGraph(navController = navController, startDestination = startDestination)
        }
    }
}

@Composable
fun MainBottomNavigationBar(navController: NavHostController) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    val bottomNavItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.SearchRepos
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        bottomNavItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            val current = backStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = selected,
                // 해당 아이템의 route를 설정
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(current!!){
                            inclusive = true
                        }
                    }
                    startDestination = item.route
                },
                label = {
                    Text(
                        text = item.name,
                        fontWeight = FontWeight.SemiBold,
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "${item.name} Icon",
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHeader(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                "Compose 아키텍처"
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Image(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "뒤로가기"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen(navController = rememberNavController())
}
