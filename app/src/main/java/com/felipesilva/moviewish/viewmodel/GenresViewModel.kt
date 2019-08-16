package com.felipesilva.moviewish.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Genres
import com.felipesilva.moviewish.repository.genres.GenresRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class GenresViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein: Kodein by closestKodein(application)
    private val genresRepository: GenresRepository by instance()

    init {
        genresRepository.makeCallGenresList()
    }

    fun getGenresList(): LiveData<Genres> = genresRepository.getGenresList()
}