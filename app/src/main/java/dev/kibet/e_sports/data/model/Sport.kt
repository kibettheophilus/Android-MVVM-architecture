package dev.kibet.e_sports.data.model


import com.google.gson.annotations.SerializedName

data class Sport(
    @SerializedName("idSport")
    val idSport: String,
    @SerializedName("strFormat")
    val strFormat: String,
    @SerializedName("strSport")
    val strSport: String,
    @SerializedName("strSportDescription")
    val strSportDescription: String,
    @SerializedName("strSportThumb")
    val strSportThumb: String,
    @SerializedName("strSportThumbGreen")
    val strSportThumbGreen: String
)