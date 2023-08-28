package com.example.data.repository

import com.example.data.datasource.ExampleDataSource
import com.example.domain.model.ExampleModel
import com.example.domain.repository.ExampleRepository
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val dataSource: ExampleDataSource
): ExampleRepository {
    override fun getExampleModel(): ExampleModel {
        return dataSource.getExampleModel()
    }
}