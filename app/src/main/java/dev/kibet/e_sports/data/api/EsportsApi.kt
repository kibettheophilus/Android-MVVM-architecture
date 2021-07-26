package dev.kibet.e_sports.data.api

import dev.kibet.e_sports.data.model.SportsResponse
import dev.kibet.e_sports.util.Resource
import retrofit2.http.GET

interface EsportsApi {

    @GET("/all_sports.php")
    suspend fun getAllSports(): Resource<SportsResponse>?

}