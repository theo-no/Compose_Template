package com.example.data.mapper

import com.example.data.model.response.RepoInfoResponse
import com.example.data.model.response.RepoResponse
import com.example.domain.model.RepoDto
import com.example.domain.model.RepoInfoDto

fun RepoResponse.toDomain(): RepoDto{
    return RepoDto(
        id, name, htmlUrl, url, gitUrl
    )
}

fun RepoInfoResponse.toDomain(): RepoInfoDto{
    return RepoInfoDto(
        name, description, htmlUrl, visibility
    )
}