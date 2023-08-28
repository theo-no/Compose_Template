package com.example.data.service

import com.example.data.datasource.response.ExampleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ExampleService {
    @GET("users/{user}/repos")
    suspend fun getExampleRepos(@Path("user") user:String): List<ExampleResponse>
}