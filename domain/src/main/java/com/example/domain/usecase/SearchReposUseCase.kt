package com.example.domain.usecase

import android.util.Log
import com.example.domain.model.RepoDto
import com.example.domain.model.NetworkResult
import com.example.domain.repository.GitHubRepository
import javax.inject.Inject

private const val TAG = "SearchReposUseCase 차선호"
class SearchReposUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
){
//    suspend operator fun invoke(user: String): List<RepoDto> {
//        return when (val result = gitHubRepository.getUserRepos(user)) {
//            is NetworkResult.Success -> {
//                Log.d(TAG, "success -> ${result.data}")
//                result.data
//            }
//            else -> {
//                Log.d(TAG, "fail...")
//                listOf()
//            }
//        }
//    }
    suspend operator fun invoke(user: String): List<RepoDto>{
        return gitHubRepository.getUserRepos(user)
    }
}