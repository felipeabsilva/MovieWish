package com.felipesilva.moviewish.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Genre
import com.felipesilva.moviewish.data.model.MovieDetails
import com.felipesilva.moviewish.data.model.ProductionCompanie
import com.felipesilva.moviewish.repository.MovieDetailsRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MovieDetailsViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein: Kodein by closestKodein(application.applicationContext)
    private val movieDetailsRepository: MovieDetailsRepository by instance()

    fun makeCallMovieDetails(movieId: Int) = movieDetailsRepository.makeCallMovieDetails(movieId)
    fun getMovieDetails(): LiveData<MovieDetails> = movieDetailsRepository.getMovieDetails()

    fun formatGenres(genres: List<Genre>): String {
        val stringBuilder = StringBuilder("Genres: ")

        genres.apply {
            if (isNotEmpty()) {
                this.forEach {
                    if (indexOf(it) != lastIndex)
                        stringBuilder.append("${it.name}, ")
                    else
                        stringBuilder.append(it.name)
                }
            } else {
                stringBuilder.append("Not specified")
            }
        }

        return stringBuilder.toString()
    }

    fun formatProductionCompanies(productionCompanies: List<ProductionCompanie>): String {
        val stringBuilder = StringBuilder("Production: ")

        productionCompanies.apply {
            if (isNotEmpty()) {
                this.forEach {
                    if (indexOf(it) != lastIndex)
                        stringBuilder.append("${it.name}, ")
                    else
                        stringBuilder.append(it.name)
                }
            } else {
                stringBuilder.append("Not specified")
            }
        }

        return stringBuilder.toString()
    }
}