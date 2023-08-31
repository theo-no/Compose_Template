package com.example.data.datasource.remote

import android.util.Log
import com.example.data.model.response.RepoInfoResponse
import com.example.data.model.response.RepoResponse
import com.example.data.service.GitHubService
import com.example.data.service.handleApi
import com.example.data.model.NetworkResult

private const val TAG = "GitHubDataSourceImpl 차선호"
class GitHubDataSourceImpl(
    private val gitHubService: GitHubService
): GitHubDataSource{
    override suspend fun getUserRepos(user: String): NetworkResult<List<RepoResponse>> {
        return handleApi { gitHubService.getUserRepos(user) }
    }

    override suspend fun getRepoInfo(user: String, repo: String): NetworkResult<RepoInfoResponse> {
        Log.d(TAG, "getRepoInfo... $user $repo ")
        return handleApi { gitHubService.getRepoInfo(user, repo)}
    }
}