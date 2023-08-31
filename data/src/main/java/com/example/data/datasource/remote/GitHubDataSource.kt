package com.example.data.datasource.remote

import com.example.data.model.response.RepoInfoResponse
import com.example.data.model.response.RepoResponse
import com.example.data.model.NetworkResult

interface GitHubDataSource {
    suspend fun getUserRepos(user: String): NetworkResult<List<RepoResponse>>

    suspend fun getRepoInfo(user: String, repo: String): NetworkResult<RepoInfoResponse>
}