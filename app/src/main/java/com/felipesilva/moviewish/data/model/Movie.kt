package com.felipesilva.moviewish.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movies(
    val results: List<Movie>
)

/**
"popularity": 456.135,
"vote_count": 568,
"video": false,
"poster_path": "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
"id": 384018,
"adult": false,
"backdrop_path": "/hpgda6P9GutvdkDX5MUJ92QG9aj.jpg",
"original_language": "en",
"original_title": "Fast & Furious Presents: Hobbs & Shaw",
"genre_ids": [
28
],
"title": "Fast & Furious Presents: Hobbs & Shaw",
"vote_average": 6.5,
"overview": "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
"release_date": "2019-08-02"
 */

data class Movie(
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("video") val video: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("id") val id: Int,
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("genre_ids") val gender_ids: List<Int>,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: Date
)