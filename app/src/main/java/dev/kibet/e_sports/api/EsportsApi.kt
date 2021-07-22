package dev.kibet.e_sports.api

import dev.kibet.e_sports.data.model.MatchRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EsportsApi {

    @GET("/countries")
    suspend fun getMatches(
        @Body matchRequest: MatchRequest
    ): MatchRequest

}