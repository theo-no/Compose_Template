package com.example.data.mapper

import com.example.data.datasource.response.ExampleResponse
import com.example.domain.model.ExampleModel

fun ExampleResponse.toDomain(): ExampleModel{
    return ExampleModel(
        id, name
//        , htmlUrl, url, gitUrl
    )
}