package com.example.predatector.repository

import com.example.predatector.models.ApiResponse
import com.example.predatector.models.Predator
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object PredatorRepository {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun fetchPredators(): List<Predator> {
        val response: ApiResponse = client.get("https://randomuser.me/api/?results=10").body()
        return response.results
    }
}
