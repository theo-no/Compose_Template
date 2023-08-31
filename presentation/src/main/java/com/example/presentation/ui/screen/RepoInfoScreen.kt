package com.example.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.domain.model.RepoInfoDto
import com.example.presentation.viewmodel.RepoInfoViewModel

private const val TAG = "RepoInfoScreen 차선호"
@Composable
fun RepoInfoScreen(
    userName: String = "",
    repoName: String = "",
    viewModel: RepoInfoViewModel = hiltViewModel(),
    navController: NavController
){
    viewModel.getRepoInfo(userName, repoName)
    val repoInfoDtoState by viewModel.selectedRepo.collectAsState() // CollectAsState를 이용해 상태 플로우 감시
    Log.d(TAG, "RepoInfoScreen... $repoInfoDtoState")
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = repoInfoDtoState.name,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = repoInfoDtoState.description?:"No Description",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = repoInfoDtoState.htmlUrl,
            fontSize = 8.sp
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = "visibility : ${repoInfoDtoState.visibility}",
        )
    }
}


@Preview(showBackground = true)
@Composable
fun RepoInfoScreenPreview(){
    RepoInfoScreen(navController = rememberNavController())
}