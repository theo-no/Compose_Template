package com.example.domain.repository

import com.example.domain.model.ExampleModel

interface ExampleRepository {
    fun getExampleModel(): ExampleModel
}