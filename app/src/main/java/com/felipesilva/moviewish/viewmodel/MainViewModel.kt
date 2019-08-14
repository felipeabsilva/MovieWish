package com.felipesilva.moviewish.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.felipesilva.moviewish.data.model.Movie
import com.felipesilva.moviewish.repository.Repository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein: Kodein by closestKodein(application.applicationContext)
    val repository: Repository by instance()

    fun makeCallMoviesSortedByMostPopular() = repository.makeCallMoviesSortedByMostPopular()
    fun getMovies(): LiveData<List<Movie>> = repository.getMovies()
}