package dev.kibet.e_sports.data.model

data class Response(
    val match_id: Int,
    val status_code: Int,
    val status: String,
    val match_start: String,
    val league_id: Int,
    val season_id: Int,
    val home_team: TeamInfo,
    val away_team: TeamInfo,
    val stats: Stats,
    val venue: Venue
)


data class TeamInfo(
    val team_id : Int,
    val name: String,
    val short_code: String,
    val logo: String,
    val country: Country)

    data class Country(
    val country_id:Int,
    val name: String,
    val country_code: String,
    val continent: String
)

data class Stats(
    val home_score: Int,
    val away_score: Int,
    val ht_score: String,
    val ft_score: String,
    val et_score: String?,
     val ps_score: String?
)
data class Venue(
    val venue_id: Int,
    val name: String,
    val capacity: Int,
    val city: String,
    val country_id: Int
)

