package com.example.data.service

import com.example.data.entity.response.RepoInfoResponse
import com.example.data.entity.response.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun getUserRepos(@Path("user") user:String): List<RepoResponse>

    @GET("repos/{user}/{repo}")
    suspend fun getRepoInfo(@Path("user") user: String, @Path("repo") repo: String): RepoInfoResponse
}