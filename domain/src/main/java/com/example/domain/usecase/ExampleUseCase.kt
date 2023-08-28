package com.example.domain.usecase

import com.example.domain.model.ExampleModel
import com.example.domain.model.NetworkResult
import com.example.domain.repository.ExampleRepository
import javax.inject.Inject


class ExampleUseCase @Inject constructor(
    private val exampleRepository: ExampleRepository
){
    suspend operator fun invoke(user: String): List<ExampleModel> {
        return when (val result = exampleRepository.getExampleRepos(user)) {
            is NetworkResult.Success -> result.data
            else -> listOf()
        }
    }
}