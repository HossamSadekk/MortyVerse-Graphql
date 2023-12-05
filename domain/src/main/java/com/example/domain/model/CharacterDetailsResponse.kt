package com.example.domain.model

data class CharacterModel(
    val id: String,
    val image: String,
    val status: String,
    val name: String,
    val species: String,
    val type: String,
    val gender: String,
    val episodes: List<Episode>,
    val location: Location
)

data class CharacterDetailsResponse(
    val character: CharacterModel?
)

data class Episode(
    val id: String,
    val name: String,
    val air_date: String
)

data class Location(
    val id: String,
    val name: String
)