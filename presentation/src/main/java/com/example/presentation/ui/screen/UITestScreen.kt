package com.example.presentation.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun UITestScreen(
    navController: NavController
){

    Text(
        "text"
    )
}

@Preview(showBackground = true)
@Composable
fun UITestScreenPreview(){
    UITestScreen(navController = rememberNavController())
}