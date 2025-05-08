// models/Predator.kt
package com.example.predatector.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val results: List<Predator>
)

@Serializable
data class Predator(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val dob: Dob,
    val registered: Registered,
    val phone: String,
    val picture: Picture,
)

@Serializable
data class Name(val title: String, val first: String, val last: String)

@Serializable
data class Location(val city: String, val country: String)

@Serializable
data class Dob(val date: String, val age: Int)

@Serializable
data class Registered(val date: String)

@Serializable
data class Picture(val large: String, val medium: String, val thumbnail: String)
