package com.felipesilva.moviewish.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: Date,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("budget") val budget: Double,
    @SerializedName("revenue") val revenue: Double,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanie>

)

data class ProductionCompanie(
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logoPath: String,
    @SerializedName("name") val name: String,
    @SerializedName("origin_country") val originCountry: String
)