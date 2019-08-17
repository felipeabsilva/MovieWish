package com.felipesilva.moviewish.utilities

object API {
    const val BASE_URL = "https://api.themoviedb.org/"

    const val IMAGE_POSTER_URL = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"
    const val IMAGE_DETAIL_POSTER_URL = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/"

    private const val API_VERSION_3 = "3"
    private const val API_VERSION_4 = "4"

    object Header {
        const val AUTHORIZATION_KEY = "Authorization"
        const val AUTHORIZATION_VALUE =
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1NzE3OGVjNTc3YmZmNDRjYWIxYWE5YzYzNDEzMGM3YyIsInN1YiI6IjVkNTNlNjg2NGIwYzYzNTAxNDdhMDMzMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5g1MxqIi5q5tzRuu-dl3bm0BF4ehNR709Eh1fT8CTw0"
    }

    object Path {
        const val MOVIE_ID_KEY = "movie_id"

        const val MOVIE_DISCOVER = "$API_VERSION_4/discover/movie"
        const val MOVIE_DETAILS = "$API_VERSION_3/movie/{$MOVIE_ID_KEY}"
        const val GENRE_LIST = "$API_VERSION_3/genre/movie/list"
        const val SEARCH_MOVIE = "$API_VERSION_3/search/movie"
    }

    object Query {
        const val API_KEY_VALUE = "57178ec577bff44cab1aa9c634130c7c"
        const val API_KEY_KEY = "api_key"

        const val QUERY_KEY = "query"

        const val PAGE_KEY = "page"
        const val PAGE_1_VALUE = 1

        const val INCLUDE_ADULT_KEY = "include_adult"

        const val FALSE_VALUE = false

        const val LANGUAGE_KEY = "language"
        const val LANGUAGE_EN_US_VALUE = "en-US"

        const val WITH_GENRES_KEY= "with_genres"

        const val SORT_BY_KEY = "sort_by"
        const val SORT_BY_POPULARITY_DESC_VALUE = "popularity.desc"
        const val SORT_BY_VOTE_AVERAGE_DESC_VALUE = "vote_average.desc"

        const val VOTE_COUNT_KEY = "vote_count.gte"
        const val VOTE_COUNT_500_VALUE = 500

        const val PRIMARY_RELEASE_DATE_GTE_KEY = "primary_release_date.gte"
    }
}