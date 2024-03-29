package com.felipesilva.moviewish.data.database.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.moviewish.data.model.Movie
import com.felipesilva.moviewish.data.model.Movies
import com.felipesilva.moviewish.remote.MovieAPI
import com.felipesilva.moviewish.remote.config.RetrofitConfig
import com.felipesilva.moviewish.utilities.getCurrentFormmatedDate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MoviesDatabaseImpl(retrofitConfig: RetrofitConfig) :
    MoviesDatabase {
    private val moviesList = mutableListOf<Movie>()
    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()

    private val api = retrofitConfig.buildRetrofit()
        .create(MovieAPI::class.java)

    private val handleMoviesCallback = object : Callback<Movies> {
        override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
            response.apply {
                if (this.body() != null) {
                    response.body()?.let {
                        loadMovies(it)
                    }
                } else {
                    movies.value = null
                }
            }
        }

        override fun onFailure(call: Call<Movies>, t: Throwable) {
            movies.value = null
        }
    }

    override fun makeCallMoviesSortedByMostPopular() =
        api.makeCallMoviesSortedByMostPopular().enqueue(handleMoviesCallback)

    override fun makeCallMoviesSortByTopRated() = api.makeCallMoviesSortByTopRated().enqueue(handleMoviesCallback)

    override fun makeCallMoviesSortByUpcoming() =
        api.makeCallMoviesSortByUpcoming(Date().getCurrentFormmatedDate()).enqueue(handleMoviesCallback)

    override fun makeCallMoviesByGenre(genreId: String) =
        api.makeCallMoviesByGenre(genreId).enqueue(handleMoviesCallback)

    override fun makeCallMoviesSearch(query: String) = api.makeCallMoviesSearch(query).enqueue(handleMoviesCallback)

    override fun loadMovies(movies: Movies) {
        if (moviesList.isNotEmpty())
            moviesList.clear()

        moviesList.addAll(movies.results)
        this.movies.value = moviesList
    }

    override fun getMovies(): LiveData<List<Movie>> = movies
}