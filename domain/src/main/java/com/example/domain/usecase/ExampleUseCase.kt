package com.example.domain.usecase

import android.util.Log
import com.example.domain.model.ExampleModel
import com.example.domain.model.NetworkResult
import com.example.domain.repository.ExampleRepository
import javax.inject.Inject

private const val TAG = "ExampleUseCase 차선호"
class ExampleUseCase @Inject constructor(
    private val exampleRepository: ExampleRepository
){
    suspend operator fun invoke(user: String): List<ExampleModel> {
        return when (val result = exampleRepository.getExampleRepos(user)) {
            is NetworkResult.Success -> {
                Log.d(TAG, "success -> ${result.data}")
                result.data
            }
            else -> {
                Log.d(TAG, "fail...")
                listOf()
            }
        }
    }
}