package com.example.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.viewmodel.ExampleViewModel

private const val TAG = "ExampleScreen 차선호"
@Composable
fun ExampleScreen(
    viewModel: ExampleViewModel = hiltViewModel(),
    navController: NavController
){
    LazyColumn {
        item {
            Button(onClick = {
                viewModel.getExampleRepos("theo-no")
            }) {
                Text("리포지토리 가져오기")
            }
        }
        items(viewModel.exampleRepos.value) {
            Text(it.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleScreenPreview(){
    ExampleScreen(navController = rememberNavController())
}