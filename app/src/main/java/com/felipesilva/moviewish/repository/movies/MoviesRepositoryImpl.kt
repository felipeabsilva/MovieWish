package com.felipesilva.moviewish.repository.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.moviewish.data.database.movies.MoviesDatabase
import com.felipesilva.moviewish.data.model.Movie

class MoviesRepositoryImpl(private val moviesDatabase: MoviesDatabase) :
    MoviesRepository {
    private val moviesList = mutableListOf<Movie>()
    private val movies: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        moviesDatabase.getMovies().observeForever {
            if (it != null) {
                if (moviesList.isNotEmpty())
                    moviesList.clear()

                moviesList.addAll(it)

                movies.value = moviesList
            } else {
                movies.value = it
            }
        }
    }

    override fun makeCallMoviesSortedByMostPopular() = moviesDatabase.makeCallMoviesSortedByMostPopular()

    override fun makeCallMoviesSortByUpcoming() = moviesDatabase.makeCallMoviesSortByUpcoming()

    override fun makeCallMoviesSortByTopRated() = moviesDatabase.makeCallMoviesSortByTopRated()

    override fun makeCallMoviesByGenre(genreId: String) = moviesDatabase.makeCallMoviesByGenre(genreId)

    override fun getMovies(): LiveData<List<Movie>> = movies
}