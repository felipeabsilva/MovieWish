package com.felipesilva.moviewish.data.database

import android.util.Log
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

class MoviesDatabaseImpl(private val retrofitConfig: RetrofitConfig) : MoviesDatabase {
    private val moviesList = mutableListOf<Movie>()

    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    private val api = retrofitConfig.buildRetrofit()
        .create(MovieAPI::class.java)

    private val handleCallback = object : Callback<Movies> {
        override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
            response.body()?.let {
                loadMovies(it)
            }
        }

        override fun onFailure(call: Call<Movies>, t: Throwable) {
            Log.d("MoviesDatabaseImpl", "Connection movies failed!")
        }
    }

    override fun makeCallMoviesSortedByMostPopular() = api.makeCallMoviesSortedByMostPopular().enqueue(handleCallback)

    override fun makeCallMoviesSortByTopRated() = api.makeCallMoviesSortByTopRated().enqueue(handleCallback)

    override fun makeCallMoviesSortByUpcoming() = api.makeCallMoviesSortByUpcoming(Date().getCurrentFormmatedDate()).enqueue(handleCallback)

    override fun loadMovies(movies: Movies) {
        if (moviesList.isNotEmpty())
            moviesList.clear()

        moviesList.addAll(movies.results)
        this.movies.value = moviesList
    }

    override fun getMovies(): LiveData<List<Movie>> = movies
}