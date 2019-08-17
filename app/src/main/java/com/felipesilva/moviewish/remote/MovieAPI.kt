package com.felipesilva.moviewish.remote

import com.felipesilva.moviewish.data.model.Genres
import com.felipesilva.moviewish.data.model.MovieDetails
import com.felipesilva.moviewish.data.model.Movies
import com.felipesilva.moviewish.utilities.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

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
        @Query(API.Query.PRIMARY_RELEASE_DATE_GTE_KEY) primaryReleaseDate: String,
        @Query(API.Query.SORT_BY_KEY) sortBy: String = API.Query.SORT_BY_POPULARITY_DESC_VALUE
    ): Call<Movies>

    @GET(API.Path.SEARCH_MOVIE)
    fun makeCallMoviesSearch(
        @Query(API.Query.QUERY_KEY) query: String,
        @Query(API.Query.API_KEY_KEY) apiKey: String = API.Query.API_KEY_VALUE,
        @Query(API.Query.SORT_BY_KEY) sortBy: String = API.Query.SORT_BY_POPULARITY_DESC_VALUE,
        @Query(API.Query.LANGUAGE_KEY) language: String = API.Query.LANGUAGE_EN_US_VALUE,
        @Query(API.Query.PAGE_KEY) page: Int = API.Query.PAGE_1_VALUE,
        @Query(API.Query.INCLUDE_ADULT_KEY) includeAdult: Boolean = API.Query.FALSE_VALUE
    ): Call<Movies>

    @Headers("${API.Header.AUTHORIZATION_KEY}: ${API.Header.AUTHORIZATION_VALUE}")
    @GET(API.Path.MOVIE_DISCOVER)
    fun makeCallMoviesByGenre(
        @Query(API.Query.WITH_GENRES_KEY) genreId: String,
        @Query(API.Query.API_KEY_KEY) apiKey: String = API.Query.API_KEY_VALUE,
        @Query(API.Query.SORT_BY_KEY) sortBy: String = API.Query.SORT_BY_POPULARITY_DESC_VALUE
    ): Call<Movies>

    @GET(API.Path.MOVIE_DETAILS)
    fun makeCallMovieDetails(
        @Path(API.Path.MOVIE_ID_KEY) movieId: Int,
        @Query(API.Query.API_KEY_KEY) apiKey: String = API.Query.API_KEY_VALUE,
        @Query(API.Query.LANGUAGE_KEY) language: String = API.Query.LANGUAGE_EN_US_VALUE
    ): Call<MovieDetails>

    @GET(API.Path.GENRE_LIST)
    fun makeCallGenreList(
        @Query(API.Query.API_KEY_KEY) apiKey: String = API.Query.API_KEY_VALUE,
        @Query(API.Query.LANGUAGE_KEY) language: String = API.Query.LANGUAGE_EN_US_VALUE
    ): Call<Genres>
}