package com.felipesilva.moviewish.data.database

import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Genres
import com.felipesilva.moviewish.data.model.MovieDetails

interface GenresDatabase {
    fun makeCallGenresList()
    fun loadGenresList(genresList: Genres)
    fun getGenresList(): LiveData<Genres>
}