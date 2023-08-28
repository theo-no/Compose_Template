package com.example.domain.repository

import com.example.domain.model.ExampleModel
import com.example.domain.model.NetworkResult

interface ExampleRepository {
    suspend fun getExampleRepos(user: String): NetworkResult<List<ExampleModel>>
}