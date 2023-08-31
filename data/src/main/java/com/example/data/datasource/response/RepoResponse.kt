package com.example.data.datasource.response

import com.google.gson.annotations.SerializedName

data class RepoResponse(
    val id: Long,
    val name: String,
    val htmlUrl: String,
    val url: String,
    val gitUrl: String
)