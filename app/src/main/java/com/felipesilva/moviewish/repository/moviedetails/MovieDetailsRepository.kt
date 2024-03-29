package com.felipesilva.moviewish.repository.moviedetails

import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.MovieDetails

interface MovieDetailsRepository {
    fun makeCallMovieDetails(movieId: Int)
    fun getMovieDetails(): LiveData<MovieDetails>
}