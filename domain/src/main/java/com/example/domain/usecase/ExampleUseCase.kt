package com.example.domain.usecase

import com.example.domain.model.ExampleModel
import com.example.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleUseCase @Inject constructor(
    private val repository: ExampleRepository
){
    fun getExampleModel(): ExampleModel{
        return repository.getExampleModel()
    }
}