package com.felipesilva.moviewish.remote

import com.felipesilva.moviewish.data.model.Movies
import com.felipesilva.moviewish.utilities.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieAPI {
    @Headers("${API.Header.AUTHORIZATION_KEY}: ${API.Header.AUTHORIZATION_VALUE}")
    @GET(API.Path.MOVIE_DISCOVER)
    fun makeCallMoviesSortedByMostPopular(
        @Query(API.Query.SORT_BY_KEY) sortBy: String = API.Query.SORT_BY_POPULARITY_DESC_VALUE
    ): Call<Movies>

    @Headers("${API.Header.AUTHORIZATION_KEY}: ${API.Header.AUTHORIZATION_VALUE}")
    @GET(API.Path.MOVIE_DISCOVER)
    fun makeCallMoviesSortByTopRated(
        @Query(API.Query.SORT_BY_KEY) sortBy: String = API.Query.SORT_BY_VOTE_AVERAGE_DESC_VALUE,
        @Query(API.Query.VOTE_COUNT_KEY) voteCount: Int = API.Query.VOTE_COUNT_500_VALUE
    ): Call<Movies>

    @Headers("${API.Header.AUTHORIZATION_KEY}: ${API.Header.AUTHORIZATION_VALUE}")
    @GET(API.Path.MOVIE_DISCOVER)
    fun makeCallMoviesSortByUpcoming(
        @Query(API.Query.PRIMARY_RELEASE_DATE_GTE_KEY) primaryReleaseDate: String
    ): Call<Movies>
}