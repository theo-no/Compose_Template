package com.example.presentation.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navHostController: NavHostController
){
    Text(
        "ui 1"
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navHostController = rememberNavController())
}