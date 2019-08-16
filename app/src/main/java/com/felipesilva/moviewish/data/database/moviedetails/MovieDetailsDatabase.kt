package com.felipesilva.moviewish.data.database.moviedetails

import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.MovieDetails

interface MovieDetailsDatabase {
    fun makeCallMovieDetails(movieId: Int)
    fun loadMovieDetails(movieDetails: MovieDetails)
    fun getMovieDetails(): LiveData<MovieDetails>
}