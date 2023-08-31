package com.example.data.repository


import android.util.Log
import com.example.data.datasource.remote.GitHubDataSource
import com.example.data.mapper.toDomain
import com.example.data.service.GitHubService
import com.example.data.service.handleApi
import com.example.domain.model.RepoDto
import com.example.domain.model.NetworkResult
import com.example.domain.model.RepoInfoDto
import com.example.domain.repository.GitHubRepository
import javax.inject.Inject

private const val TAG = "GitHubRepositoryImpl 차선호"
//class GitHubRepositoryImpl @Inject constructor(
//    private val gitHubService: GitHubService
//): GitHubRepository {
//    override suspend fun getUserRepos(user: String): NetworkResult<List<RepoDto>> {
//        return handleApi { gitHubService.getUserRepos(user).map { it.toDomain() } }
//    }
//
//    override suspend fun getRepoInfo(user: String, repo: String): NetworkResult<RepoInfoDto> {
//        Log.d(TAG, "getRepoInfo... $user $repo ")
//        return handleApi { gitHubService.getRepoInfo(user, repo).toDomain()}
//    }
//}

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubDataSource: GitHubDataSource
): GitHubRepository {
    override suspend fun getUserRepos(user: String): List<RepoDto> {
        return when (val result = gitHubDataSource.getUserRepos(user)) {
            is NetworkResult.Success -> {
                Log.d(TAG, "success... ${result.data}")
                result.data.map { it.toDomain() }
            }
            else -> {
                Log.d(TAG, "fail...$result")
                listOf()
            }
        }
//        return handleApi { gitHubDataSource.getUserRepos(user).map { it.toDomain() }
    }

    override suspend fun getRepoInfo(user: String, repo: String): RepoInfoDto {
        return when (val result = gitHubDataSource.getRepoInfo(user, repo)) {
            is NetworkResult.Success -> {
                Log.d(TAG, "success... ${result.data}")
                result.data.toDomain()
            }
            else -> {
                Log.d(TAG, "fail...$result")
                RepoInfoDto()
            }
        }
    }

}