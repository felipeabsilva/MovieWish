package com.felipesilva.moviewish.utilities

object API {
    const val BASE_URL = "https://api.themoviedb.org/"

    private const val API_VERSION_3 = "3"
    private const val API_VERSION_4 = "4"

    object Header {
        const val AUTHORIZATION_KEY = "Authorization"
        const val AUTHORIZATION_VALUE =
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1NzE3OGVjNTc3YmZmNDRjYWIxYWE5YzYzNDEzMGM3YyIsInN1YiI6IjVkNTNlNjg2NGIwYzYzNTAxNDdhMDMzMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.5g1MxqIi5q5tzRuu-dl3bm0BF4ehNR709Eh1fT8CTw0"
    }

    object Path {
        const val MOVIE_DISCOVER = "${API_VERSION_4}/discover/movie"
    }

    object Query {
        const val API_KEY = "57178ec577bff44cab1aa9c634130c7c"

        const val SORT_BY_KEY = "sort_by"
        const val SORT_BY_POPULARITY_DESC_VALUE = "popularity.desc"
        const val SORT_BY_VOTE_AVERAGE_DESC_VALUE = "vote_average.desc"

        const val VOTE_COUNT_KEY = "vote_count.gte"
        const val VOTE_COUNT_500_VALUE = 500

        const val PRIMARY_RELEASE_DATE_GTE_KEY = "primary_release_date.gte"
    }
}