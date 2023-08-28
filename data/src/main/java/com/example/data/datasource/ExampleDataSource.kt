package com.example.data.datasource

import com.example.domain.model.ExampleModel
import javax.inject.Inject

class ExampleDataSource @Inject constructor(
){
    fun getExampleModel(): ExampleModel{
        return ExampleModel("exampleModel")
    }
}