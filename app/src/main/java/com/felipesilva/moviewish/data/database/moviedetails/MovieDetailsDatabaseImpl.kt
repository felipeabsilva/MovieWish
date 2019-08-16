package com.felipesilva.moviewish.data.database.moviedetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.moviewish.data.model.MovieDetails
import com.felipesilva.moviewish.remote.MovieAPI
import com.felipesilva.moviewish.remote.config.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsDatabaseImpl(retrofitConfig: RetrofitConfig) :
    MovieDetailsDatabase {
    private val movieDetails: MutableLiveData<MovieDetails> = MutableLiveData()

    private val api = retrofitConfig.buildRetrofit()
        .create(MovieAPI::class.java)

    private val handleMovieDetailsCallback = object : Callback<MovieDetails> {
        override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
            response.apply {
                if (this.body() != null) {
                    this.body()?.let {
                        loadMovieDetails(it)
                    }
                } else {
                    movieDetails.value = null
                }
            }
        }

        override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
            Log.e("MoviesDetailsDatabase", "Error on movie details call")
        }

    }

    override fun loadMovieDetails(movieDetails: MovieDetails) {
        this.movieDetails.value = movieDetails
    }

    override fun getMovieDetails(): LiveData<MovieDetails> = movieDetails

    override fun makeCallMovieDetails(movieId: Int) {
        api.makeCallMovieDetails(movieId).enqueue(handleMovieDetailsCallback)
    }
}