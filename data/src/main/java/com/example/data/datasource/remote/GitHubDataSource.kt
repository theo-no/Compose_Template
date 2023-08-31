package com.example.data.datasource.remote

import com.example.data.entity.response.RepoInfoResponse
import com.example.data.entity.response.RepoResponse
import com.example.domain.model.NetworkResult
import com.example.domain.model.RepoDto
import com.example.domain.model.RepoInfoDto

interface GitHubDataSource {
    suspend fun getUserRepos(user: String): NetworkResult<List<RepoResponse>>

    suspend fun getRepoInfo(user: String, repo: String): NetworkResult<RepoInfoResponse>
}