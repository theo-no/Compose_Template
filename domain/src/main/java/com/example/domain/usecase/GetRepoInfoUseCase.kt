package com.example.domain.usecase

import android.util.Log
import com.example.domain.model.NetworkResult
import com.example.domain.model.RepoDto
import com.example.domain.model.RepoInfoDto
import com.example.domain.repository.GitHubRepository
import javax.inject.Inject

private const val TAG = "GetRepoInfoUseCase 차선호"
class GetRepoInfoUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
){
    suspend operator fun invoke(user: String, repo: String): RepoInfoDto {
        return when (val result = gitHubRepository.getRepoInfo(user, repo)) {
            is NetworkResult.Success -> {
                Log.d(TAG, "success... ${result.data}")
                result.data
            }
            else -> {
                Log.d(TAG, "fail...")
                RepoInfoDto()
            }
        }
    }
}