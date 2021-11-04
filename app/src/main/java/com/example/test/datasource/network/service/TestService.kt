package com.example.test.datasource.network.service

import com.example.test.datasource.network.Constants.BASE_URL
import com.example.test.datasource.network.response.TestResponse
import com.example.test.domain.Test
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

// /test
class TestService(
    private val httpClient: HttpClient
) {
    suspend fun getTest(): Test {
        return httpClient.get<TestResponse> {
            contentType(ContentType.Application.Json)
            url("${BASE_URL}/endpoint")
        }.toTest()
    }

}