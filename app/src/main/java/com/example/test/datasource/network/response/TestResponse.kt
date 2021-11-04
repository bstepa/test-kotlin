package com.example.test.datasource.network.response

import com.example.test.domain.Test
import kotlinx.serialization.Serializable

@Serializable
data class TestResponse(
    val api_repo: String,
    val facts: String,
    val pics_repo: String,
    val url: String
){
    fun toTest(): Test{
        return Test(
            api_repo, facts, pics_repo, url
        )
    }
}