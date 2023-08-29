package com.example.data.datasource.response

import com.google.gson.annotations.SerializedName

data class ExampleResponse(
    val id: Long,
    val name: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    val url: String,

    @SerializedName("git_url")
    val gitUrl: String
)