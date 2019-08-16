package com.felipesilva.moviewish.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.moviewish.data.database.GenresDatabase
import com.felipesilva.moviewish.data.model.Genres

class GenresRepositoryImpl(private val genresDatabase: GenresDatabase) : GenresRepository {
    private val genresList: MutableLiveData<Genres> = MutableLiveData()

    init {
        genresDatabase.getGenresList().observeForever {
            genresList.value = it
        }
    }

    override fun getGenresList(): LiveData<Genres> = genresList

    override fun makeCallGenresList() = genresDatabase.makeCallGenresList()
}