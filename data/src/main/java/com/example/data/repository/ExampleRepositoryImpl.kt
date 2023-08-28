package com.example.data.repository


import com.example.data.mapper.toDomain
import com.example.data.service.ExampleService
import com.example.data.service.handleApi
import com.example.domain.model.ExampleModel
import com.example.domain.model.NetworkResult
import com.example.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val exampleService: ExampleService
): ExampleRepository {
    override suspend fun getExampleRepos(user: String): NetworkResult<List<ExampleModel>> {
        return handleApi { exampleService.getExampleRepos(user).map { it.toDomain() } }
    }
}