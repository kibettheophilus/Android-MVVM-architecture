package dev.kibet.e_sports.data.model

data class MatchRequest(
    val season_id: String,
    val date_from: String,
    val apikey: String //APi key
)
