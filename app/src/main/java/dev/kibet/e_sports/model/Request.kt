package dev.kibet.e_sports.model

data class Request(
    val season_id: String,
    val date_from: String,
    val apikey: String //APi key
)
