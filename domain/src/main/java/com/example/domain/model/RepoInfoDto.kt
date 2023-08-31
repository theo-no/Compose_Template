package com.example.domain.model

data class RepoInfoDto (
    val name: String,
    val description: String?,
    val htmlUrl: String,
    val visibility: String
){
    constructor() : this("", "", "", "")
}