package com.felipesilva.moviewish.repository.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.moviewish.data.database.moviedetails.MovieDetailsDatabase
import com.felipesilva.moviewish.data.model.MovieDetails

class MovieDetailsRepositoryImpl(private val moviesDetailsDatabase: MovieDetailsDatabase) :
    MovieDetailsRepository {
    private val movieDetails: MutableLiveData<MovieDetails> = MutableLiveData()

    init {
        moviesDetailsDatabase.getMovieDetails().observeForever {
            movieDetails.value = it
        }
    }

    override fun makeCallMovieDetails(movieId: Int) = moviesDetailsDatabase.makeCallMovieDetails(movieId)

    override fun getMovieDetails(): LiveData<MovieDetails> = movieDetails

}