package com.felipesilva.moviewish.data.database

import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Movie
import com.felipesilva.moviewish.data.model.MovieDetails
import com.felipesilva.moviewish.data.model.Movies

interface MoviesDatabase {
    fun makeCallMoviesSortedByMostPopular()
    fun makeCallMoviesSortByTopRated()
    fun makeCallMoviesSortByUpcoming()
    fun loadMovies(movies: Movies)
    fun getMovies(): LiveData<List<Movie>>
    fun makeCallMoviesByGenre(genreId: String)
}