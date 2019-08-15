package com.felipesilva.moviewish.repository

import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Movie

interface Repository {
    fun makeCallMoviesSortedByMostPopular()
    fun makeCallMoviesSortByTopRated()
    fun makeCallMoviesSortByUpcoming()
    fun getMovies(): LiveData<List<Movie>>
}