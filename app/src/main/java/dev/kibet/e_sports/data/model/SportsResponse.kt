package dev.kibet.e_sports.data.model


import com.google.gson.annotations.SerializedName

data class SportsResponse(
    @SerializedName("sports")
    val sports: List<Sport>
)