package com.felipesilva.moviewish.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.moviewish.data.database.MoviesDatabase
import com.felipesilva.moviewish.data.model.Movie

class RepositoryImpl(private val moviesDatabase: MoviesDatabase) : Repository {
    private val moviesList = mutableListOf<Movie>()
    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        moviesDatabase.getMovies().observeForever {
            it?.let {
                if (moviesList.isNotEmpty())
                    moviesList.clear()
            }

            moviesList.addAll(it)
            movies.value = moviesList
        }
    }

    override fun makeCallMoviesSortedByMostPopular() = moviesDatabase.makeCallMoviesSortedByMostPopular()

    override fun makeCallMoviesSortByUpcoming() = moviesDatabase.makeCallMoviesSortByUpcoming()

    override fun makeCallMoviesSortByTopRated() = moviesDatabase.makeCallMoviesSortByTopRated()

    override fun getMovies(): LiveData<List<Movie>> = movies
}