package com.felipesilva.moviewish.repository.movies

import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Movie

interface MoviesRepository {
    fun makeCallMoviesSortedByMostPopular()
    fun makeCallMoviesSortByTopRated()
    fun makeCallMoviesSortByUpcoming()
    fun getMovies(): LiveData<List<Movie>>
    fun makeCallMoviesByGenre(genreId: String)
}