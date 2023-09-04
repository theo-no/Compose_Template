package com.example.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.navigation.NavGraph
import com.example.presentation.ui.screen.MainScreen
import com.example.presentation.ui.theme.ComposeTemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTemplateTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(rememberNavController())
//                Scaffold(
//                    topBar = {
//                        // 스텝 1: `topBar`를 `TopAppBar`로 채워 봅시다.
//                        TopAppBar(
//                            title = {
//                                Text(
//                                    "Compose 아키텍처"
//                                )
//                            },
//                            navigationIcon = {
//                                IconButton(onClick = {
//                                    onBackPressed()
//                                }) {
//                                    Image(
//                                        imageVector = Icons.Filled.ArrowBack,
//                                        contentDescription = "뒤로가기"
//                                    )
//                                }
//                            }
//                        )
//                    }) {
//                    Surface(
//                        modifier = Modifier.padding(it)
//                    ) {
//                        NavGraph()
//                    }
//                }
            }
        }
    }
}
