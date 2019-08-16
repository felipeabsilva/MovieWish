package com.felipesilva.moviewish.repository

import androidx.lifecycle.LiveData
import com.felipesilva.moviewish.data.model.Genres

interface GenresRepository {
    fun getGenresList(): LiveData<Genres>
    fun makeCallGenresList()
}