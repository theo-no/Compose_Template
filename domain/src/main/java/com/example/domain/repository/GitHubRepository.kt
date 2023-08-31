package com.example.domain.repository

import com.example.domain.model.RepoDto
import com.example.domain.model.NetworkResult
import com.example.domain.model.RepoInfoDto

//interface GitHubRepository {
//    suspend fun getUserRepos(user: String): NetworkResult<List<RepoDto>>
//
//    suspend fun getRepoInfo(user: String, repo: String): NetworkResult<RepoInfoDto>
//}

interface GitHubRepository {
    suspend fun getUserRepos(user: String): List<RepoDto>

    suspend fun getRepoInfo(user: String, repo: String): RepoInfoDto
}