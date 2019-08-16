package com.felipesilva.moviewish.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Movie
import com.felipesilva.moviewish.repository.movies.MoviesRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class HomeViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein: Kodein by closestKodein(application.applicationContext)
    val moviesRepository: MoviesRepository by instance()

    fun makeCallMoviesSortedByMostPopular() = moviesRepository.makeCallMoviesSortedByMostPopular()

    fun makeCallMoviesSortByUpcoming() = moviesRepository.makeCallMoviesSortByUpcoming()

    fun makeCallMoviesSortByTopRated() = moviesRepository.makeCallMoviesSortByTopRated()

    fun makeCallMoviesByGenre(genreId: String) = moviesRepository.makeCallMoviesByGenre(genreId)

    fun getMovies(): LiveData<List<Movie>> = moviesRepository.getMovies()
}